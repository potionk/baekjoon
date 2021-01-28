package bj1707;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Main {
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int t = 0; t < tcNum; t++) {
            isBipartite = true;
            Map<Integer, LinkedHashSet<Integer>> graph = new HashMap<>();
            String[] VE = br.readLine().split(" ");
            int V = Integer.parseInt(VE[0]);
            int E = Integer.parseInt(VE[1]);
            boolean[] isVisited = new boolean[V + 1];
            boolean[] isBlack = new boolean[V + 1]; // true->black, false-> white로 색칠
            for (int i = 0; i < E; i++) {
                String[] e = br.readLine().split(" ");
                int a = Integer.parseInt(e[0]);
                int b = Integer.parseInt(e[1]);
                graphEdgeLink(graph, a, b);
                graphEdgeLink(graph, b, a);
            }
            for (int i = 1; i < V + 1; i++) {
                if (!isVisited[i]) {
                    isBlack[i] = true;
                    isVisited[i] = true;
                    dfs(graph, i, true, isVisited, isBlack);
                }
            }
            bw.write(isBipartite ? "YES\n" : "NO\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(Map<Integer, LinkedHashSet<Integer>> graph, int vertex, boolean black, boolean[] isVisited, boolean[] isBlack) {
        LinkedHashSet<Integer> set = graph.get(vertex);
        if (set != null) {
            for (int i : set) {
                if (!isVisited[i]) {
                    isBlack[i] = !black;
                    isVisited[i] = true;
                    dfs(graph, i, !black, isVisited, isBlack);
                } else {
                    if (black == isBlack[i]) {
                        isBipartite = false;
                    }
                }
            }
        }
    }

    public static void graphEdgeLink(Map<Integer, LinkedHashSet<Integer>> graph, int a, int b) {
        LinkedHashSet<Integer> set;
        if (graph.get(a) != null) {
            set = graph.get(a);
        } else {
            set = new LinkedHashSet<>();
        }
        set.add(b);
        graph.put(a, set);
    }
}
