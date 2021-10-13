package bj12836;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NQ = br.readLine().split(" ");
        int N = Integer.parseInt(NQ[0]);
        int Q = Integer.parseInt(NQ[1]);
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        long[] tree = new long[treeSize];
        for (int i = 0; i < Q; i++) {
            String[] input = br.readLine().split(" ");
            int mode = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if (mode == 1) {
                update(1, 0, N - 1, a - 1, b, tree);
            } else {
                bw.write(find(1, 0, N - 1, a - 1, b - 1, tree) + "\n");
            }
        }
        bw.close();
        br.close();
    }

    public static long find(int idx, int start, int end, int left, int right, long[] tree) {
        if (left > end || right < start) {
            return 0;
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            return find(idx * 2, start, (start + end) / 2, left, right, tree) + find(idx * 2 + 1, (start + end) / 2 + 1, end, left, right, tree);
        }
    }

    public static void update(int idx, int start, int end, int targetIdx, long money, long[] tree) {
        if (!(targetIdx < start || targetIdx > end)) {
            tree[idx] += money;
            if (start != end) {
                update(idx * 2, start, (start + end) / 2, targetIdx, money, tree);
                update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, money, tree);
            }
        }
    }
}