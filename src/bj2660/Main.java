package bj2660;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] bfsIsVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int vertexNum = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        List<Integer> candidateList = new LinkedList<>();
        graph = new ArrayList[vertexNum + 1];
        for (int i = 0; i < vertexNum + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        bfsIsVisited = new boolean[vertexNum + 1];
        while (true) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            if (a == -1 && b == -1) {
                break;
            }
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = vertexNum; i >= 1; i--) {
            int bfsResult = bfs(i);
            if (bfsResult < min) {
                candidateList = new LinkedList<>();
                candidateList.add(i);
                min = bfsResult;
            } else if (bfsResult == min) {
                candidateList.add(i);
            }
            bfsIsVisited = new boolean[vertexNum + 1];
        }
        Collections.sort(candidateList);
        bw.write(min + " " + candidateList.size() + "\n");
        for (int i : candidateList) {
            bw.write(i + " ");
        }
        bw.close();
        br.close();
    }

    public static int bfs(int vertex) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        bfsIsVisited[vertex] = true;
        int count = -1;
        while (queue.size() != 0) {
            int queueSize = queue.size();
            count++;
            for (int q = 0; q < queueSize; q++) {
                int p = queue.poll();
                for (int i = 0; i < graph[p].size(); i++) {
                    int nextVertex = graph[p].get(i);
                    if (!bfsIsVisited[nextVertex]) {
                        queue.add(nextVertex);
                        bfsIsVisited[nextVertex] = true;
                    }
                }
            }
        }
        return count;
    }
}