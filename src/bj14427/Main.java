package bj14427;

import java.io.*;

public class Main {
    static Data[] data, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        data = new Data[N];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new Data[treeSize];
        String[] aArr = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            data[i] = new Data(Integer.parseInt(aArr[i]), i + 1);
        }
        int M = Integer.parseInt(br.readLine());
        initTree(1, 0, N - 1);
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("1")) {
                int a = Integer.parseInt(input[1]);
                int b = Integer.parseInt(input[2]);
                update(1, 0, N - 1, a - 1, new Data(b, a));
            } else {
                bw.write(findMin(1, 0, N - 1, 0, N - 1).idx + "\n");
            }
        }
        bw.flush();
    }

    public static Data initTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = data[start];
        } else {
            Data a = initTree(idx * 2, start, (start + end) / 2);
            Data b = initTree(idx * 2 + 1, (start + end) / 2 + 1, end);
            if (a.compareTo(b) < 0) {
                tree[idx] = a;
            } else {
                tree[idx] = b;
            }
        }
        return tree[idx];
    }

    public static Data update(int idx, int start, int end, int targetIdx, Data changeValue) {
        if (!(targetIdx < start || targetIdx > end)) {
            if (start != end) {
                Data a = update(idx * 2, start, (start + end) / 2, targetIdx, changeValue);
                Data b = update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, changeValue);
                if (a.compareTo(b) < 0) {
                    tree[idx] = a;
                } else {
                    tree[idx] = b;
                }
            } else {
                tree[idx] = changeValue;
            }
        }
        return tree[idx];
    }

    public static Data findMin(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return new Data(Integer.MAX_VALUE, -1);
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            Data a = findMin(idx * 2, start, (start + end) / 2, left, right);
            Data b = findMin(idx * 2 + 1, (start + end) / 2 + 1, end, left, right);
            if (a.compareTo(b) < 0) {
                return a;
            } else {
                return b;
            }
        }
    }

    private static class Data implements Comparable<Data> {
        int data;
        int idx;

        public Data(int data, int idx) {
            this.data = data;
            this.idx = idx;
        }

        @Override
        public int compareTo(Data o) {
            if (this.data == o.data) {
                return Integer.compare(this.idx, o.idx);
            } else {
                return Integer.compare(this.data, o.data);
            }
        }
    }
}