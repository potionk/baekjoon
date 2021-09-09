package bj1238;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] VEX = br.readLine().split(" ");
        int N = Integer.parseInt(VEX[0]);
        int edgeNum = Integer.parseInt(VEX[1]);
        int X = Integer.parseInt(VEX[2]);
        int[] initDist = new int[N + 1];
        int[] studentToX = new int[N + 1];
        int[] dist;
        ArrayList<Vertex>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeNum; i++) {
            String[] readEdge = br.readLine().split(" ");
            int start = Integer.parseInt(readEdge[0]);
            int finish = Integer.parseInt(readEdge[1]);
            int weight = Integer.parseInt(readEdge[2]);
            graph[start].add(new Vertex(finish, weight));
        }
        for (int i = 1; i <= N; i++) {
            initDist[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= N; i++) {
            dist = Arrays.copyOf(initDist, initDist.length);
            dist[i] = 0;
            dijkstra(i, graph, dist);
            studentToX[i] = dist[X];
        }
        int result = -1;
        dist = Arrays.copyOf(initDist, initDist.length);
        dist[X] = 0;
        dijkstra(X, graph, dist);
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, studentToX[i] + dist[i]);
        }
        bw.write(result + "");
        bw.flush();
    }

    public static void dijkstra(int startIdx, ArrayList<Vertex>[] graph, int[] dist) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(startIdx, 0));
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