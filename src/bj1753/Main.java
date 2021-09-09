package bj1753;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] VE = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(VE[0]);
        int edgeNum = Integer.parseInt(VE[1]);
        int startIdx = Integer.parseInt(br.readLine());
        int[] dist = new int[vertexNum + 1];
        ArrayList<Vertex>[] graph = new ArrayList[vertexNum + 1];
        for (int i = 0; i < vertexNum + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeNum; i++) {
            String[] readEdge = br.readLine().split(" ");
            int start = Integer.parseInt(readEdge[0]);
            int finish = Integer.parseInt(readEdge[1]);
            int weight = Integer.parseInt(readEdge[2]);
            graph[start].add(new Vertex(finish, weight));
        }
        for (int i = 1; i <= vertexNum; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[startIdx] = 0;
        dijkstra(startIdx, graph, dist);
        for (int i = 1; i <= vertexNum; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }
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

        public Vertex(int idx, int distance) {
            this.idx = idx;
            this.weight = distance;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(this.weight, v.weight);
        }
    }
}
