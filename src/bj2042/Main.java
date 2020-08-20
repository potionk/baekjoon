// segment tree
package bj2042;

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
            long c = Long.parseLong(input[2]);
            if (a == 1) {
                long diff = c - data[b - 1];
                data[b - 1] = c;
                update(1, 0, N - 1, b - 1, diff);
            } else {
                bw.write(sum(1, 0, N - 1, b - 1, (int) c - 1) + "\n");
            }
        }
        bw.flush();
    }

    public static long initTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = data[start]; // leaf node
        } else {
            tree[idx] = initTree(idx * 2, start, (start + end) / 2) + initTree(idx * 2 + 1, (start + end) / 2 + 1, end);
        }
        return tree[idx];
    }

    public static long sum(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            return sum(idx * 2, start, (start + end) / 2, left, right) + sum(idx * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

    public static void update(int idx, int start, int end, int targetIdx, long diff) {
        if (!(targetIdx < start || targetIdx > end)) {
            tree[idx] += diff;
            if (start != end) {
                update(idx * 2, start, (start + end) / 2, targetIdx, diff);
                update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, diff);
            }
        }
    }
}
