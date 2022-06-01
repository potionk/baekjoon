package bj21937;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int x, count;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init();
        visited[x] = true;
        dfs(x);
        bw.write(count + "");
        bw.close();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        graph = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            graph.get(b).add(a);
        }
        x = Integer.parseInt(br.readLine()) - 1;
        br.close();
        count = -1;
    }

    public static void dfs(int cur) {
        count++;
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
