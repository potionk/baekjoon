package bj1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] bfsIsVisited;
    static int max;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(testCase[0]);
        int edgeNum = Integer.parseInt(testCase[1]);
        result = new ArrayList<>();
        max = -1;
        graph = new ArrayList[vertexNum + 1];
        for (int i = 0; i < vertexNum + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeNum; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph[b].add(a);
        }
        for (int i = 1; i < vertexNum + 1; i++) {
            bfsIsVisited = new boolean[vertexNum + 1];
            int res = bfs(i);
            if (res > max) {
                result = new ArrayList<>();
                result.add(i);
                max = res;
            } else if (res == max) {
                result.add(i);
            }
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

    public static int bfs(int vertex) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        bfsIsVisited[vertex] = true;
        int count = 0;
        while (queue.size() != 0) {
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                int p = queue.poll();
                for (int i = 0; i < graph[p].size(); i++) {
                    int nextVertex = graph[p].get(i);
                    if (!bfsIsVisited[nextVertex]) {
                        queue.add(nextVertex);
                        bfsIsVisited[nextVertex] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }
}