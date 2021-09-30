package bj2268;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        long[] tree = new long[treeSize];
        long[] arr = new long[N];
        initTree(1, 0, N - 1, arr, tree);
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int mode = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if (mode == 1) {
                long diff = b - arr[a - 1];
                arr[a - 1] = b;
                update(1, 0, N - 1, a - 1, diff, tree);
            } else {
                if (b < a) {
                    a = a ^ b;
                    b ^= a;
                    a = a ^ b;
                }
                bw.write(sum(1, 0, N - 1, a - 1, b - 1, tree) + "\n");
            }
        }
        bw.close();
        br.close();
    }

    public static long initTree(int idx, int start, int end, long[] arr, long[] tree) {
        if (start == end) {
            tree[idx] = arr[start];
        } else {
            tree[idx] = initTree(idx * 2, start, (start + end) / 2, arr, tree) + initTree(idx * 2 + 1, (start + end) / 2 + 1, end, arr, tree);
        }
        return tree[idx];
    }

    public static long sum(int idx, int start, int end, int left, int right, long[] tree) {
        if (left > end || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            return sum(idx * 2, start, (start + end) / 2, left, right, tree) + sum(idx * 2 + 1, (start + end) / 2 + 1, end, left, right, tree);
        }
    }

    public static void update(int idx, int start, int end, int targetIdx, long diff, long[] tree) {
        if (!(targetIdx < start || targetIdx > end)) {
            tree[idx] += diff;
            if (start != end) {
                update(idx * 2, start, (start + end) / 2, targetIdx, diff, tree);
                update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, diff, tree);
            }
        }
    }
}