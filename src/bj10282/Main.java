package bj10282;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] ndc = br.readLine().split(" ");
            int vertexNum = Integer.parseInt(ndc[0]);
            int edgeNum = Integer.parseInt(ndc[1]);
            int startIdx = Integer.parseInt(ndc[2]);
            int[] dist = new int[vertexNum + 1];
            ArrayList<Vertex>[] graph = new ArrayList[vertexNum + 1];
            for (int i = 0; i < vertexNum + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < edgeNum; i++) {
                String[] readEdge = br.readLine().split(" ");
                int finish = Integer.parseInt(readEdge[0]);
                int start = Integer.parseInt(readEdge[1]);
                int weight = Integer.parseInt(readEdge[2]);
                graph[start].add(new Vertex(finish, weight));
            }
            for (int i = 1; i <= vertexNum; i++) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[startIdx] = 0;
            dijkstra(startIdx, graph, dist);
            int result = Integer.MIN_VALUE;
            int count = 0;
            for (int i = 1; i <= vertexNum; i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    result = Math.max(dist[i], result);
                    count++;
                }
            }
            bw.write(count + " " + result + "\n");
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