package bj1725;

import java.io.*;

public class Main {
    static int[] data, tree;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, h + 1);
        tree = new int[treeSize];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        initTree(1, 0, N - 1);
        bw.write(findMaxArea(0, N - 1) + "\n");
        bw.flush();
    }

    public static int initTree(int idx, int start, int end) {
        if (start == end) {
            tree[idx] = start;
        } else {
            int leftIdx = initTree(idx * 2, start, (start + end) / 2);
            int rightIdx = initTree(idx * 2 + 1, (start + end) / 2 + 1, end);
            if (data[leftIdx] >= data[rightIdx]) {
                tree[idx] = rightIdx;
            } else {
                tree[idx] = leftIdx;
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
            int leftIdx = findMin(idx * 2, start, (start + end) / 2, left, right);
            int rightIdx = findMin(idx * 2 + 1, (start + end) / 2 + 1, end, left, right);
            if (leftIdx == Integer.MAX_VALUE) {
                return rightIdx;
            } else if (rightIdx == Integer.MAX_VALUE) {
                return leftIdx;
            } else {
                if (data[rightIdx] > data[leftIdx]) {
                    return leftIdx;
                } else {
                    return rightIdx;
                }
            }
        }
    }

    public static long findMaxArea(int start, int end) {
        int idx = findMin(1, 0, N - 1, start, end);
        long area = (long) data[idx] * (end - start + 1);
        if (start < idx) {
            area = Math.max(area, findMaxArea(start, idx - 1));
        }
        if (idx < end) {
            area = Math.max(area, findMaxArea(idx + 1, end));
        }
        return area;
    }
}