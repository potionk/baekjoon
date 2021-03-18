package bj9372;

import java.io.*;
import java.util.*;

public class Main {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            boolean[] isVisited = new boolean[N + 1];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < M; i++) {
                String[] ab = br.readLine().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                List<Integer> list;
                if (graph.get(a) == null) {
                    list = new LinkedList<>();
                } else {
                    list = graph.get(a);
                }
                list.add(b);
                graph.put(a, list);
                if (graph.get(b) == null) {
                    list = new LinkedList<>();
                } else {
                    list = graph.get(b);
                }
                list.add(a);
                graph.put(b, list);
            }
            count = 0;
            dfs(1, graph, isVisited);
            bw.write((count - 1) + "\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int idx, Map<Integer, List<Integer>> graph, boolean[] isVisited) {
        isVisited[idx] = true;
        count++;
        for (int next : graph.get(idx)) {
            if (!isVisited[next]) {
                dfs(next, graph, isVisited);
            }
        }
    }
}
