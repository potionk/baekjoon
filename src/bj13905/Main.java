package bj13905;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] startFinish = br.readLine().split(" ");
        int start = Integer.parseInt(startFinish[0]);
        int finish = Integer.parseInt(startFinish[1]);
        parent = new int[n + 1];
        Edge[] edges = new Edge[m];
        makeSet(n);
        for (int i = 0; i < m; i++) {
            String[] readLine = br.readLine().split(" ");
            edges[i] = new Edge(Integer.parseInt(readLine[0]), Integer.parseInt(readLine[1]), Integer.parseInt(readLine[2]));
        }
        bw.write(kruskal(n, edges, start, finish) + "");
        bw.close();
        br.close();
    }

    public static int kruskal(int n, Edge[] edges, int start, int finish) {
        Arrays.sort(edges);
        int count = 0;
        for (Edge e : edges) {
            if (count == n - 1) {
                break;
            }
            int a = e.a;
            int b = e.b;
            if (find(a) != find(b)) {
                count++;
                union(a, b);
            }
            if (find(start) == find(finish)) {
                return e.cost;
            }
        }
        return 0;
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
        public final int a;
        public final int b;
        public final int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.cost, this.cost);
        }
    }
}