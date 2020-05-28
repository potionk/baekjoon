package bj1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static boolean[][] graph;
    static boolean[] bfsIsVisited;
    static int max;
    static List<Integer> result;
    static int vertexNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        vertexNum = Integer.parseInt(testCase[0]);
        int edgeNum = Integer.parseInt(testCase[1]);
        result = new ArrayList<>();
        max = -1;
        graph = new boolean[vertexNum + 1][vertexNum + 1];
        for (int i = 0; i < edgeNum; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph[b][a] = true;
        }
        for (int i = 1; i < vertexNum + 1; i++) {
            bfsIsVisited = new boolean[vertexNum + 1];
            int res = bfs(i);
            result.add(res);
            max = Math.max(res, max);
        }
        int resSize = result.size();
        for (int i = 0; i < resSize; i++) {
            int c = result.get(i);
            if (c == max)
                System.out.print(i + 1 + " ");
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
                for (int i = 1; i < vertexNum; i++) {
                    if(graph[p][i]){
                        if (!bfsIsVisited[i]) {
                            queue.add(i);
                            bfsIsVisited[i] = true;
                        }
                    }
                }
            }
            count++;
        }
        return count;
    }
}