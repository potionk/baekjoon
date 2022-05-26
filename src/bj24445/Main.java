package bj24445;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static List<List<Integer>> graph;
    static int[] visitOrder;

    public static void main(String[] args) throws IOException {
        init();
        bfs(r);
        printResult();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmr = br.readLine().split(" ");
        n = Integer.parseInt(nmr[0]);
        m = Integer.parseInt(nmr[1]);
        r = Integer.parseInt(nmr[2]);
        visitOrder = new int[n];
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]) - 1;
            int v = Integer.parseInt(uv[1]) - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        br.close();
    }

    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex - 1);
        int visitCount = 1;
        boolean[] visited = new boolean[n];
        visited[vertex - 1] = true;
        while (queue.size() != 0) {
            int p = queue.poll();
            visitOrder[p] = visitCount++;
            graph.get(p).sort(Comparator.reverseOrder());
            for (int next : graph.get(p)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void printResult() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int order : visitOrder) {
            bw.write(order + "\n");
        }
        bw.close();
    }
}
