package bj1506;

import java.io.*;
import java.util.*;

public class Main {
    static int id;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int vertexNum = Integer.parseInt(br.readLine());
        int[] cost = new int[vertexNum];
        ArrayList<Integer>[] graph = new ArrayList[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            graph[i] = new ArrayList<>();
        }
        String[] costStr = br.readLine().split(" ");
        for (int i = 0; i < vertexNum; i++) {
            cost[i] = Integer.parseInt(costStr[i]);
        }
        for (int i = 0; i < vertexNum; i++) {
            String s = br.readLine();
            for (int j = 0; j < vertexNum; j++) {
                if (s.charAt(j) == '1') {
                    graph[i].add(j);
                }
            }
        }
        int[] idArr = new int[vertexNum];
        Stack<Integer> stack = new Stack<>();
        boolean[] isFinished = new boolean[vertexNum];
        id = 1;
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        for (int i = 0; i < vertexNum; i++) {
            if (idArr[i] == 0) {
                dfs(i, graph, idArr, stack, isFinished, result);
            }
        }
        int resultCost = 0;
        for (LinkedList<Integer> list : result) {
            int min = Integer.MAX_VALUE;
            for (int i : list) {
                min = Math.min(cost[i], min);
            }
            resultCost += min;
        }
        bw.write(resultCost + "");
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