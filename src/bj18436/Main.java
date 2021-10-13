package bj18436;

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
            if (Integer.parseInt(aArr[i]) % 2 == 0) {
                data[i] = Data.evenNumber();
            } else {
                data[i] = Data.oddNumber();
            }
        }
        int M = Integer.parseInt(br.readLine());
        initTree(1, 0, N - 1);
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if (input[0].equals("1")) {
                if (!((b % 2 == 0 && data[a - 1].evenNum == 1) || (b % 2 == 1 && data[a - 1].oddNum == 1))) {
                    if (b % 2 == 0) {
                        data[a - 1] = Data.evenNumber();
                    } else {
                        data[a - 1] = Data.oddNumber();
                    }
                    update(1, 0, N - 1, a - 1, data[a - 1]);
                }

            } else if (input[0].equals("2")) {
                bw.write(find(1, 0, N - 1, a - 1, b - 1).evenNum + "\n");
            } else {
                bw.write(find(1, 0, N - 1, a - 1, b - 1).oddNum + "\n");
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
            tree[idx] = new Data(a.oddNum + b.oddNum, a.evenNum + b.evenNum);
        }
        return tree[idx];
    }

    public static Data update(int idx, int start, int end, int targetIdx, Data changeValue) {
        if (!(targetIdx < start || targetIdx > end)) {
            if (start != end) {
                Data a = update(idx * 2, start, (start + end) / 2, targetIdx, changeValue);
                Data b = update(idx * 2 + 1, (start + end) / 2 + 1, end, targetIdx, changeValue);
                tree[idx] = new Data(a.oddNum + b.oddNum, a.evenNum + b.evenNum);
            } else {
                tree[idx] = changeValue;
            }
        }
        return tree[idx];
    }

    public static Data find(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return new Data(0, 0);
        } else if (left <= start && end <= right) {
            return tree[idx];
        } else {
            Data a = find(idx * 2, start, (start + end) / 2, left, right);
            Data b = find(idx * 2 + 1, (start + end) / 2 + 1, end, left, right);
            return new Data(a.oddNum + b.oddNum, a.evenNum + b.evenNum);
        }
    }

    private static class Data {
        int oddNum;
        int evenNum;

        public Data(int oddNum, int evenNum) {
            this.oddNum = oddNum;
            this.evenNum = evenNum;
        }

        public static Data oddNumber() {
            return new Data(1, 0);
        }

        public static Data evenNumber() {
            return new Data(0, 1);
        }
    }
}