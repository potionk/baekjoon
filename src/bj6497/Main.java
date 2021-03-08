package bj6497;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            if (n == 0 && m == 0) {
                break;
            }
            parent = new int[n];
            Edge[] edges = new Edge[m];
            makeSet(n);
            int totalCost = 0;
            for (int i = 0; i < m; i++) {
                String[] readLine = br.readLine().split(" ");
                int cost = Integer.parseInt(readLine[2]);
                edges[i] = new Edge(Integer.parseInt(readLine[0]), Integer.parseInt(readLine[1]), cost);
                totalCost += cost;
            }
            bw.write(totalCost - kruskal(n, edges) + "\n");
        }
        bw.close();
        br.close();
    }

    public static int kruskal(int n, Edge[] edges) {
        Arrays.sort(edges);
        int sum = 0;
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
        for (int i = 0; i < x; i++) {
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