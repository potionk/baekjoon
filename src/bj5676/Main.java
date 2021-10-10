package bj5676;

import java.io.*;

public class Main {
    static int[] data, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            String[] tc = input.split(" ");
            int N = Integer.parseInt(tc[0]);
            int K = Integer.parseInt(tc[1]);
            data = new int[N];
            int h = (int) Math.ceil(Math.log(N) / Math.log(2));
            int treeSize = (int) Math.pow(2, h + 1);
            tree = new int[treeSize];
            String[] num = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                data[i] = Integer.compare(Integer.parseInt(num[i]), 0);
            }
            initTree(1, 0, N - 1);
            for (int i = 0; i < K; i++) {
                String[] readLine = br.readLine().split(" ");
                int a = Integer.parseInt(readLine[1]);
                int b = Integer.parseInt(readLine[2]);
                if (readLine[0].equals("C")) {
                    b = Integer.compare(b, 0);
                    data[a - 1] = b;
                    update(1, 0, N - 1, a - 1, b);
                } else {
                    int t = mul(1, 0, N - 1, a - 1, b - 1);
                    bw.write(convertIntToChar(t));
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static char convertIntToChar(int i) {
        if (i > 0) {
            return '+';
        } else if (i == 0) {
            return '0';
        } else {
            return '-';
        }
    }

    public static int initTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = data[start];
        } else {
            tree[idx] = (initTree(idx * 2, start, (start + end) / 2) * initTree(idx * 2 + 1, (start + end) / 2 + 1, end));
        }
        return tree[idx];
    }

    public static int mul(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 1;
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            return (mul(idx * 2, start, (start + end) / 2, left, right) * mul(idx * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }
    }

    public static int update(int idx, int start, int end, int targetIdx, int changeValue) {
        if (!(targetIdx < start || targetIdx > end)) {
            if (start != end) {
                tree[idx] = (update(idx * 2, start, (start + end) / 2, targetIdx, changeValue) * update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, changeValue));
            } else {
                tree[idx] = changeValue;
            }
        }
        return tree[idx];
    }
}