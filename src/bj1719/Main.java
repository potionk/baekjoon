package bj1719;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] VE = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(VE[0]);
        int edgeNum = Integer.parseInt(VE[1]);
        int[] initDist = new int[vertexNum + 1];
        int[][] result = new int[vertexNum][vertexNum];
        ArrayList<Vertex>[] graph = new ArrayList[vertexNum + 1];
        for (int i = 1; i < vertexNum + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeNum; i++) {
            String[] readEdge = br.readLine().split(" ");
            int a = Integer.parseInt(readEdge[0]);
            int b = Integer.parseInt(readEdge[1]);
            int weight = Integer.parseInt(readEdge[2]);
            graph[a].add(new Vertex(b, weight));
            graph[b].add(new Vertex(a, weight));
        }
        for (int i = 1; i <= vertexNum; i++) {
            initDist[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= vertexNum; i++) {
            int[] dist = Arrays.copyOf(initDist, initDist.length);
            int[] before = new int[vertexNum + 1];
            dist[i] = 0;
            dijkstra(i, graph, dist, before);
            for (int j = 0; j < vertexNum; j++) {
                result[j][i - 1] = before[j + 1];
            }
        }
        for (int i = 0; i < vertexNum; i++) {
            for (int j = 0; j < vertexNum; j++) {
                if (result[i][j] == -1) {
                    bw.write("- ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }

    public static void dijkstra(int startIdx, ArrayList<Vertex>[] graph, int[] dist, int[] before) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(startIdx, 0));
        before[startIdx] = -1;
        while (!priorityQueue.isEmpty()) {
            Vertex v = priorityQueue.poll();
            int post = dist[v.idx];
            if (v.weight == Integer.MAX_VALUE) {
                break;
            } else if (post >= v.weight) {
                ArrayList<Vertex> list = graph[v.idx];
                for (Vertex next : list) {
                    int nextIndex = next.idx;
                    int weight = next.weight;
                    if (dist[nextIndex] > post + weight) {
                        priorityQueue.add(new Vertex(nextIndex, post + weight));
                        dist[nextIndex] = post + weight;
                        before[nextIndex] = v.idx;
                    }
                }
            }
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        int idx;
        int weight;

        private Vertex(int idx, int distance) {
            this.idx = idx;
            this.weight = distance;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(this.weight, v.weight);
        }
    }
}