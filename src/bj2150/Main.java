package bj2150;

import java.io.*;
import java.util.*;

public class Main {
    static int dfsOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] VE = br.readLine().split(" ");
        int v = Integer.parseInt(VE[0]);
        int e = Integer.parseInt(VE[1]);
        ArrayList<Integer>[] graph = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] d = new int[v + 1];
        for (int i = 0; i < e; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph[a].add(b);
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] isFinished = new boolean[v + 1];
        dfsOrder = 1;
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        for (int i = 1; i <= v; i++) {
            if (d[i] == 0) {
                dfs(i, graph, d, stack, isFinished, result);
            }
        }
        Map<Integer, Integer> originIdxMap = new HashMap<>();
        int idx = 0;
        int[] firstItem = new int[result.size()];
        for (LinkedList<Integer> list : result) {
            Collections.sort(list);
            firstItem[idx] = list.getFirst();
            originIdxMap.put(firstItem[idx], idx++);
        }
        Arrays.sort(firstItem);
        bw.write(firstItem.length + "\n");
        for (int k : firstItem) {
            for (int j : result.get(originIdxMap.get(k))) {
                bw.write(j + " ");
            }
            bw.write("-1\n");
        }
        br.close();
        bw.close();
    }

    public static int dfs(int curVertex, ArrayList<Integer>[] graph, int[] d, Stack<Integer> stack, boolean[] isFinished, LinkedList<LinkedList<Integer>> result) {
        stack.push(curVertex);
        d[curVertex] = dfsOrder++;
        int parent = d[curVertex];
        int len = graph[curVertex].size();
        for (int i = 0; i < len; i++) {
            int next = graph[curVertex].get(i);
            if (d[next] == 0) {
                parent = Math.min(parent, dfs(next, graph, d, stack, isFinished, result));
            } else if (!isFinished[next]) {
                parent = Math.min(parent, d[next]);
            }
        }
        if (parent == d[curVertex]) {
            LinkedList<Integer> list = new LinkedList<>();
            while (true) {
                int p = stack.pop();
                list.add(p);
                isFinished[p] = true;
                if (curVertex == p) {
                    break;
                }
            }
            result.add(list);
        }
        return parent;
    }
}