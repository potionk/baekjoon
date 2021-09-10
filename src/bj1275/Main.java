package bj1275;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int Q = Integer.parseInt(tc[1]);
        long[] data = new long[N];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)); // log2(N)
        int treeSize = (int) Math.pow(2, h + 1);
        long[] tree = new long[treeSize];
        String[] strData = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            data[i] = Long.parseLong(strData[i]);
        }
        initTree(tree, data, 1, 0, N - 1);
        for (int i = 0; i < Q; i++) {
            String[] cmd = br.readLine().split(" ");
            int x = Integer.parseInt(cmd[0]);
            int y = Integer.parseInt(cmd[1]);
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            int a = Integer.parseInt(cmd[2]);
            long b = Long.parseLong(cmd[3]);
            bw.write(sum(tree, 1, 0, N - 1, x - 1, y - 1) + "\n");
            long diff = b - data[a - 1];
            data[a - 1] = b;
            update(tree, 1, 0, N - 1, a - 1, diff);
        }
        bw.close();
        br.close();
    }

    public static long initTree(long[] tree, long[] data, int idx, int start, int end) {
        if (start == end) {
            tree[idx] = data[start]; // leaf node
        } else {
            tree[idx] = initTree(tree, data, idx * 2, start, (start + end) / 2) + initTree(tree, data, idx * 2 + 1, (start + end) / 2 + 1, end);
        }
        return tree[idx];
    }

    public static long sum(long[] tree, int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            return sum(tree, idx * 2, start, (start + end) / 2, left, right) + sum(tree, idx * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

    public static void update(long[] tree, int idx, int start, int end, int targetIdx, long diff) {
        if (!(targetIdx < start || targetIdx > end)) {
            tree[idx] += diff;
            if (start != end) {
                update(tree, idx * 2, start, (start + end) / 2, targetIdx, diff);
                update(tree, idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, diff);
            }
        }
    }
}