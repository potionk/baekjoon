package bj13232;

import java.io.*;
import java.util.*;

public class Main {
    static int id;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int vertexNum = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[vertexNum + 1];
        for (int i = 1; i < vertexNum + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] idArr = new int[vertexNum + 1];
        for (int i = 0; i < edgeNum; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph[a].add(b);
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] isFinished = new boolean[vertexNum + 1];
        id = 1;
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        for (int i = 1; i <= vertexNum; i++) {
            if (idArr[i] == 0) {
                dfs(i, graph, idArr, stack, isFinished, result);
            }
        }
        int biggestSize = 0;
        for (LinkedList<Integer> list : result) {
            biggestSize = Math.max(biggestSize, list.size());
        }
        bw.write(biggestSize + "");
        br.close();
        bw.close();
    }

    public static int dfs(int curVertex, ArrayList<Integer>[] graph, int[] idArr, Stack<Integer> stack, boolean[] isFinished, LinkedList<LinkedList<Integer>> result) {
        stack.push(curVertex);
        idArr[curVertex] = id++;
        int parent = idArr[curVertex];
        int size = graph[curVertex].size();
        for (int i = 0; i < size; i++) {
            int next = graph[curVertex].get(i);
            if (idArr[next] == 0) {
                parent = Math.min(parent, dfs(next, graph, idArr, stack, isFinished, result));
            } else if (!isFinished[next]) {
                parent = Math.min(parent, idArr[next]);
            }
        }
        if (parent == idArr[curVertex]) {
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