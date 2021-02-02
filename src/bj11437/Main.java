package bj11437;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] treeLevel, treeNode;
    static Data[] segmentTree;
    static HashMap<Integer, Integer> leafMap;
    static boolean[] dfsIsVisited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        leafMap = new HashMap<>();
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        dfsIsVisited = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        count = 0;
        treeLevel = new int[N * 2];
        treeNode = new int[N * 2];
        dfs(1, 1);
        segmentTree = new Data[(int) Math.pow(2, (int) Math.ceil(Math.log(count) / Math.log(2)) + 1)];
        initTree(1, 0, count - 1);
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            String[] tc = br.readLine().split(" ");
            int a = leafMap.get(Integer.parseInt(tc[0]));
            int b = leafMap.get(Integer.parseInt(tc[1]));
            int min, max;
            if (a > b) {
                min = b;
                max = a;
            } else {
                min = a;
                max = b;
            }
            bw.write(findMin(1, 0, count - 1, min, max).getNode() + "\n");
        }
        bw.close();
        br.close();
    }

    public static Data initTree(int idx, int start, int end) {
        if (start == end) {
            segmentTree[idx] = new Data(treeLevel[start], treeNode[start]);
        } else {
            Data a = initTree(idx * 2, start, (start + end) / 2);
            Data b = initTree(idx * 2 + 1, (start + end) / 2 + 1, end);
            if (a.getLevel() > b.getLevel()) {
                segmentTree[idx] = b;
            } else {
                segmentTree[idx] = a;
            }
        }
        return segmentTree[idx];
    }

    public static Data findMin(int idx, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return new Data(Integer.MAX_VALUE, -1);
        } else if (left <= start && end <= right) {
            return segmentTree[idx];
        } else {
            Data a = findMin(idx * 2, start, (start + end) / 2, left, right);
            Data b = findMin(idx * 2 + 1, (start + end) / 2 + 1, end, left, right);
            if (a.getLevel() > b.getLevel()) {
                return b;
            } else {
                return a;
            }
        }
    }

    public static void dfs(int vertex, int level) {
        treeLevel[count] = level;
        treeNode[count] = vertex;
        leafMap.computeIfAbsent(vertex, k -> count);
        count++;
        dfsIsVisited[vertex] = true;
        for (int i : graph[vertex]) {
            if (!dfsIsVisited[i]) {
                dfs(i, level + 1);
                treeLevel[count] = level;
                treeNode[count] = vertex;
                count++;
            }
        }
    }
}

class Data {
    int level;
    int node;

    public int getLevel() {
        return level;
    }

    public int getNode() {
        return node;
    }

    public Data(int level, int node) {
        this.level = level;
        this.node = node;
    }
}