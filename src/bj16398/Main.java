package bj16398;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = (n * (n - 1)) / 2;
        parent = new int[n + 1];
        Edge[] edges = new Edge[m];
        makeSet(n);
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String[] readline = br.readLine().split(" ");
            for (int j = i + 1; j < n; j++) {
                edges[idx++] = new Edge(i + 1, j + 1, Integer.parseInt(readline[j]));
            }
        }
        bw.write(kruskal(n, edges) + "");
        bw.close();
        br.close();
    }

    public static long kruskal(int n, Edge[] edges) {
        Arrays.sort(edges);
        long sum = 0;
        int count = 0;
        for (Edge e : edges) {
            if (count == n - 1) {
                break;
            }
            int a = e.getA();
            int b = e.getB();
            if (find(a) != find(b)) {
                count++;
                union(a, b);
                sum += e.getCost();
            }
        }
        return sum;
    }

    public static void makeSet(int x) {
        for (int i = 1; i <= x; i++) {
            parent[i] = i;
        }
    }

    public static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static class Edge implements Comparable<Edge> {
        private final int a;
        private final int b;
        private final int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.getCost());
        }
    }
}