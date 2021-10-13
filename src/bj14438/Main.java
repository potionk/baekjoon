package bj14438;

import java.io.*;

public class Main {
    static int[] data, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        data = new int[N];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new int[treeSize];
        String[] aArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(aArr[i]);
        }
        int M = Integer.parseInt(br.readLine());
        initTree(1, 0, N - 1);
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if (input[0].equals("1")) {
                update(1, 0, N - 1, a - 1, b);
            } else {
                bw.write(findMin(1, 0, N - 1, a - 1, b - 1) + "\n");
            }
        }
        bw.flush();
    }

    public static int initTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = data[start];
        } else {
            tree[idx] = Math.min(initTree(idx * 2, start, (start + end) / 2), initTree(idx * 2 + 1, (start + end) / 2 + 1, end));
        }
        return tree[idx];
    }

    public static int update(int idx, int start, int end, int targetIdx, int changeValue) {
        if (!(targetIdx < start || targetIdx > end)) {
            if (start != end) {
                tree[idx] = Math.min(update(idx * 2, start, (start + end) / 2, targetIdx, changeValue), update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, changeValue));
            } else {
                tree[idx] = changeValue;
            }
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