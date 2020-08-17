package bj11505;

import java.io.*;

public class Main {
    static long[] data, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        int K = Integer.parseInt(tc[2]);
        data = new long[N];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)); // log2(N)
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(br.readLine());
        }
        initTree(1, 0, N - 1);
        for (int i = 0; i < M + K; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if (a == 1) {
                data[b - 1] = (long) c;
                update(1, 0, N - 1, b - 1, c);
            } else {
                long t = mul(1, 0, N - 1, b - 1, c - 1);
                bw.write(t + "\n");
            }
        }
        bw.flush();
    }

    public static long initTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = data[start]; // leaf node
        } else {
            tree[idx] = (initTree(idx * 2, start, (start + end) / 2) * initTree(idx * 2 + 1, (start + end) / 2 + 1, end)) % 1000000007;
        }
        return tree[idx];
    }

    public static long mul(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            return (mul(idx * 2, start, (start + end) / 2, left, right) * mul(idx * 2 + 1, (start + end) / 2 + 1, end, left, right)) % 1000000007;
        }
    }

    public static long update(int idx, int start, int end, int targetIdx, long changeValue) {
        if (!(targetIdx < start || targetIdx > end)) {
            if (start != end) {
                tree[idx] = (update(idx * 2, start, (start + end) / 2, targetIdx, changeValue) * update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, changeValue)) % 1000000007;
            } else {
                tree[idx] = changeValue;
            }
        }
        return tree[idx];
    }
}
