package bj6543;

import java.io.*;
import java.util.*;

public class Main {
    static int dfsOrder;
    static int[] scc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] VE = br.readLine().split(" ");
            if (VE.length != 2) {
                if (VE[0].equals("0")) {
                    break;
                }
            }
            int v = Integer.parseInt(VE[0]);
            int e = Integer.parseInt(VE[1]);
            ArrayList<Integer>[] graph = new ArrayList[v + 1];
            for (int i = 1; i < v + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            int[] d = new int[v + 1];
            int[][] edges = new int[e][2];
            String[] edge = br.readLine().split(" ");
            for (int i = 0; i < e * 2; i += 2) {
                edges[i / 2][0] = Integer.parseInt(edge[i]);
                edges[i / 2][1] = Integer.parseInt(edge[i + 1]);
                graph[edges[i / 2][0]].add(edges[i / 2][1]);
            }
            Stack<Integer> stack = new Stack<>();
            boolean[] isFinished = new boolean[v + 1];
            scc = new int[v + 1];
            dfsOrder = 1;
            LinkedList<Set<Integer>> resultList = new LinkedList<>();
            for (int i = 1; i <= v; i++) {
                if (d[i] == 0) {
                    dfs(i, graph, d, stack, isFinished, resultList);
                }
            }
            int[] outDegree = new int[resultList.size()];
            for (int i = 0; i < e; i++) {
                if (scc[edges[i][0]] != scc[edges[i][1]]) {
                    outDegree[scc[edges[i][0]]]++;
                }
            }
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < outDegree.length; j++) {
                if (outDegree[j] == 0) {
                    list.addAll(new LinkedList<>(resultList.get(j)));
                }
            }
            Collections.sort(list);
            for (int i : list) {
                bw.write(i + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static int dfs(int curVertex, ArrayList<Integer>[] graph, int[] d, Stack<Integer> stack, boolean[] isFinished, LinkedList<Set<Integer>> resultList) {
        stack.push(curVertex);
        d[curVertex] = dfsOrder++;
        int parent = d[curVertex];
        int len = graph[curVertex].size();
        for (int i = 0; i < len; i++) {
            int next = graph[curVertex].get(i);
            if (d[next] == 0) {
                parent = Math.min(parent, dfs(next, graph, d, stack, isFinished, resultList));
            } else if (!isFinished[next]) {
                parent = Math.min(parent, d[next]);
            }
        }
        if (parent == d[curVertex]) {
            Set<Integer> list = new HashSet<>();
            while (true) {
                int p = stack.pop();
                list.add(p);
                isFinished[p] = true;
                scc[p] = resultList.size();
                if (curVertex == p) {
                    break;
                }
            }
            resultList.add(list);
        }
        return parent;
    }
}