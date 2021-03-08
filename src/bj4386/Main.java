package bj4386;

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
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] readLine = br.readLine().split(" ");
            points[i] = new Point(Double.parseDouble(readLine[0]), Double.parseDouble(readLine[1]), i);
        }
        Edge[] edges = new Edge[m];
        makeSet(n);
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges[idx++] = new Edge(points[i].getIdx(), points[j].getIdx(), points[i].calDistance(points[j]));
            }
        }
        bw.write(kruskal(n, edges) + "");
        bw.close();
        br.close();
    }

    public static double kruskal(int n, Edge[] edges) {
        Arrays.sort(edges);
        double sum = 0, count = 0;
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
        private final double cost;

        public Edge(int a, int b, double cost) {
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

        public double getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.getCost());
        }
    }

    private static class Point {
        private final double x;
        private final double y;
        private final int idx;

        public Point(double x, double y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public int getIdx() {
            return idx;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double calDistance(Point p) {
            return Math.sqrt(Math.pow(Math.abs(this.x - p.getX()), 2) + Math.pow(Math.abs(this.y - p.getY()), 2));
        }
    }
}