package bj14938;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmr = br.readLine().split(" ");
        int vertexNum = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int edgeNum = Integer.parseInt(nmr[2]);
        int[] initDist = new int[vertexNum + 1];
        String[] itemNumStr = br.readLine().split(" ");
        int[] itemNum = new int[itemNumStr.length];
        for (int i = 0; i < itemNum.length; i++) {
            itemNum[i] = Integer.parseInt(itemNumStr[i]);
        }
        ArrayList<Vertex>[] graph = new ArrayList[vertexNum + 1];
        for (int i = 0; i < vertexNum + 1; i++) {
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
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= vertexNum; i++) {
            int[] dist = Arrays.copyOf(initDist, initDist.length);
            dist[i] = 0;
            dijkstra(i, graph, dist);
            int availableItems = 0;
            for (int j = 1; j <= vertexNum; j++) {
                if (dist[j] != Integer.MAX_VALUE) {
                    if (dist[j] <= m) {
                        availableItems += itemNum[j - 1];
                    }
                }
            }
            result = Math.max(result, availableItems);
        }
        bw.write(result + "");
        bw.close();
        br.close();
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