package bj24479;

import java.io.*;
import java.util.*;

public class Main {
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        int r = Integer.parseInt(info[2]);
        List<Integer>[] graph = initGraph(br, n, m);
        Map<Integer, Integer> visitOrder = new HashMap<>();
        dfs(graph, r, new HashSet<>(), visitOrder);
        for (int i = 1; i < n + 1; i++) {
            bw.write(visitOrder.getOrDefault(i, 0) + "\n");
        }
        br.close();
        bw.close();
    }

    public static List<Integer>[] initGraph(BufferedReader br, int n, int m) throws IOException {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        while (m-- > 0) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]);
            int v = Integer.parseInt(uv[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    public static void dfs(List<Integer>[] graph, int point, Set<Integer> visited, Map<Integer, Integer> visitOrder) throws IOException {
        visited.add(point);
        visitOrder.put(point, order++);
        Collections.sort(graph[point]);
        for (int next : graph[point]) {
            if (!visited.contains(next)) {
                dfs(graph, next, visited, visitOrder);
            }
        }
    }
}
