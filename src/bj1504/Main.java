package bj1504;

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
        int[][] dist = new int[vertexNum + 1][4];
        ArrayList<Vertex>[] graph = new ArrayList[vertexNum + 1];
        for (int i = 0; i < vertexNum + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeNum; i++) {
            String[] readEdge = br.readLine().split(" ");
            int a = Integer.parseInt(readEdge[0]);
            int b = Integer.parseInt(readEdge[1]);
            int weight = Integer.parseInt(readEdge[2]);
            graph[a].add(new Vertex(b, weight, 0));
            graph[b].add(new Vertex(a, weight, 0));
        }
        for (int i = 1; i <= vertexNum; i++) {
            for (int j = 0; j < 4; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[1][0] = 0;
        String[] must = br.readLine().split(" ");
        int mustA = Integer.parseInt(must[0]);
        int mustB = Integer.parseInt(must[1]);
        if (1 == mustA) {
            dist[1][1] = 0;
        }
        dijkstra(1, graph, dist, mustA, mustB);
        if (dist[vertexNum][3] == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(dist[vertexNum][3] + "");
        }
        bw.flush();
    }

    public static void dijkstra(int startIdx, ArrayList<Vertex>[] graph, int[][] dist, int mustA, int mustB) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(startIdx, 0, 1 == mustA ? 1 : 0));
        while (!priorityQueue.isEmpty()) {
            Vertex v = priorityQueue.poll();
            int post = dist[v.idx][v.passState];
            if (v.weight == Integer.MAX_VALUE) {
                break;
            } else if (post >= v.weight) {
                ArrayList<Vertex> list = graph[v.idx];
                for (Vertex next : list) {
                    int nextIndex = next.idx;
                    int weight = next.weight;
                    int nextState = v.passState;
                    if (nextIndex == mustA) {
                        nextState = nextState | 1;
                    } else if (nextIndex == mustB) {
                        nextState = nextState | 2;
                    }
                    if (dist[nextIndex][nextState] > post + weight) {
                        priorityQueue.add(new Vertex(nextIndex, post + weight, nextState));
                        dist[nextIndex][nextState] = post + weight;
                    }
                }
            }
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        int idx;
        int weight;
        int passState; // 00 nobody, 01 A, 10 B, 11 All pass

        public Vertex(int idx, int distance, int passState) {
            this.idx = idx;
            this.weight = distance;
            this.passState = passState;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(this.weight, v.weight);
        }
    }
}
