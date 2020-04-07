package bj2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] dfsIsVisited;
    static int[] count;
    static boolean[] bfsIsVisited;
    static int finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertexNum = Integer.parseInt(br.readLine());
        String[] testCase = br.readLine().split(" ");
        int start = Integer.parseInt(testCase[0]);
        finish = Integer.parseInt(testCase[1]);
        int edgeNum = Integer.parseInt(br.readLine());
        bfsIsVisited = new boolean[vertexNum + 1];
        count = new int[vertexNum + 1];
        graph = new ArrayList[vertexNum + 1];
        for (int i = 0; i < vertexNum + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        dfsIsVisited = new boolean[vertexNum + 1];
        for (int i = 0; i < edgeNum; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        bfs(start);
    }

    public static void bfs(int vertex) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        count[vertex]=0;
        bfsIsVisited[vertex] = true;
        boolean isFind=false;
        while (queue.size() != 0) {
            int p = queue.poll();
            if(p==finish){
                System.out.println(count[finish]);
                isFind=true;
                break;
            }
            for (int i = 0; i < graph[p].size(); i++) {
                int nextVertex = graph[p].get(i);
                if (!bfsIsVisited[nextVertex]) {
                    queue.add(nextVertex);
                    count[nextVertex]=count[p]+1;
                    bfsIsVisited[nextVertex] = true;
                }
            }
        }
        if(!isFind)
            System.out.println(-1);
    }
}