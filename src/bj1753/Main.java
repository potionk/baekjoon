package bj1753;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<Pair<Integer, Integer>>[] graph;
    static PriorityQueue<Vertex> priorityQueue;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        priorityQueue = new PriorityQueue<>();
        String[] vertexEdge = br.readLine().split(" ");
        int vertex = Integer.parseInt(vertexEdge[0]);
        int edge = Integer.parseInt(vertexEdge[1]);
        int startVertex = Integer.parseInt(br.readLine());
        dist = new int[vertex + 1];
        graph = new ArrayList[vertex + 1];
        for (int i = 0; i < vertex + 1; i++)
            graph[i] = new ArrayList<>();
        for (int i = 0; i < edge; i++) {
            String[] readEdge = br.readLine().split(" ");
            int start = Integer.parseInt(readEdge[0]);
            int finish = Integer.parseInt(readEdge[1]);
            int weight = Integer.parseInt(readEdge[2]);
            graph[start].add(new Pair<>(finish, weight));
        }
        for (int i = 1; i <= vertex; i++) {
            dist[i] = Integer.MAX_VALUE;
            Vertex v;
            if (i == startVertex)
                v = new Vertex(i, 0);
            else
                v = new Vertex(i, Integer.MAX_VALUE);
            priorityQueue.add(v);
        }
        dist[startVertex] = 0;
        dijkstra();
        for (int i = 1; i <= vertex; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(dist[i] + "\n");
        }
        bw.flush();
    }

    public static void dijkstra() {
        while (true) {
            Vertex p = priorityQueue.poll();
            int post = dist[p.getLeft()];
            if (p.getRight() == Integer.MAX_VALUE)
                break;
            if (post >= p.getRight()) {
                ArrayList<Pair<Integer, Integer>> list = graph[p.getLeft()];
                for (Pair<Integer, Integer> next : list) {
                    int nextIndex = next.getLeft();
                    int weight = next.getRight();
                    if (dist[nextIndex] > post + weight) {
                        priorityQueue.add(new Vertex(nextIndex, post + weight));
                        dist[nextIndex] = post + weight;
                    }
                }
            }
        }
    }
}

class Vertex extends Pair<Integer, Integer> implements Comparable<Vertex> {
    public Vertex(int index, int dist) {
        super(index, dist);
    }

    @Override
    public int compareTo(Vertex target) {
        return this.getRight().compareTo(target.getRight());
    }
}

class Pair<E, F> {
    public E left;
    public F right;

    public Pair(E left, F right) {
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public F getRight() {
        return right;
    }
}
