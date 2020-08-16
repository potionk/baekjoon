package bj2357;

import java.io.*;

public class Main {
    static int[] data, minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        data = new int[N];
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)); // log2(N)
        int treeSize = (int) Math.pow(2, h + 1);
        minTree = new int[treeSize];
        maxTree = new int[treeSize];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        initMinTree(1, 0, N - 1);
        initMaxTree(1, 0, N - 1);
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            bw.write(findMin(1, 0, N - 1, a - 1, b - 1)+" "+findMax(1, 0, N - 1, a - 1, b - 1) + "\n");
        }
        bw.flush();
    }

    public static int initMinTree(int idx, int start, int end) {
        if (start == end) {
            minTree[idx] = data[start]; // leaf node
        } else {
            minTree[idx] = Math.min(initMinTree(idx * 2, start, (start + end) / 2), initMinTree(idx * 2 + 1, (start + end) / 2 + 1, end));
        }
        return minTree[idx];
    }

    public static int initMaxTree(int idx, int start, int end) {
        if (start == end) {
            maxTree[idx] = data[start]; // leaf node
        } else {
            maxTree[idx] = Math.max(initMaxTree(idx * 2, start, (start + end) / 2), initMaxTree(idx * 2 + 1, (start + end) / 2 + 1, end));
        }
        return maxTree[idx];
    }

    public static int findMin(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MAX_VALUE;
        } else if (left <= start && end <= right) {
            return minTree[idx];
        } else {
            return Math.min(findMin(idx * 2, start, (start + end) / 2, left, right), findMin(idx * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }
    }

    public static int findMax(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return Integer.MIN_VALUE;
        } else if (left <= start && end <= right) {
            return maxTree[idx];
        } else {
            return Math.max(findMax(idx * 2, start, (start + end) / 2, left, right), findMax(idx * 2 + 1, (start + end) / 2 + 1, end, left, right));
        }
    }
}