package bj10868;

import java.io.*;

public class Main {
    static int[] data, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        data = new int[N];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)); // log2(N)
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new int[treeSize];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        initTree(1, 0, N - 1);
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            bw.write(findMin(1, 0, N - 1, a - 1, b - 1) + "\n");
        }
        bw.flush();
    }

    public static int initTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = data[start]; // leaf node
        } else {
            tree[idx] = Math.min(initTree(idx * 2, start, (start + end) / 2), initTree(idx * 2 + 1, (start + end) / 2 + 1, end));
        }
        return tree[idx];
    }

    public static int findMin(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            return Math.min(findMin(idx * 2, start, (start + end) / 2, left, right), findMin(idx * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }
    }
}
