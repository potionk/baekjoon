package bj3682;

import java.io.*;
import java.util.*;

public class Main {
    static int dfsOrder;
    static int[] scc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        while (tcNum-- > 0) {
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
            for (int i = 0; i < e; i++) {
                String[] edge = br.readLine().split(" ");
                edges[i][0] = Integer.parseInt(edge[0]);
                edges[i][1] = Integer.parseInt(edge[1]);
                graph[edges[i][0]].add(edges[i][1]);
            }
            Stack<Integer> stack = new Stack<>();
            boolean[] isFinished = new boolean[v + 1];
            scc = new int[v + 1];
            dfsOrder = 1;
            LinkedList<Set<Integer>> resultList = new LinkedList<>();
            for (int i = 1; i < v + 1; i++) {
                if (d[i] == 0) {
                    dfs(i, graph, d, stack, isFinished, resultList);
                }
            }
            int sccSize = resultList.size();
            if (sccSize == 1) {
                bw.write("0\n");
            } else {
                int[] inDegree = new int[sccSize];
                int[] outDegree = new int[inDegree.length];
                for (int i = 0; i < e; i++) {
                    if (scc[edges[i][0]] != scc[edges[i][1]]) {
                        inDegree[scc[edges[i][1]]]++;
                        outDegree[scc[edges[i][0]]]++;
                    }
                }
                int outDegreeCount = 0, inDegreeCount = 0;
                for (int j = 0; j < sccSize; j++) {
                    if (inDegree[j] == 0) {
                        inDegreeCount++;
                    }
                    if (outDegree[j] == 0) {
                        outDegreeCount++;
                    }
                }
                bw.write(Math.max(outDegreeCount, inDegreeCount) + "\n");
            }
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