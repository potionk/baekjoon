package bj18126;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<DestinationInfo>> graph;
    static int n;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // init
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] roadInfo = br.readLine().split(" ");
            int a = Integer.parseInt(roadInfo[0]);
            int b = Integer.parseInt(roadInfo[1]);
            long c = Long.parseLong(roadInfo[2]);
            graph.get(a).add(new DestinationInfo(b, c));
            graph.get(b).add(new DestinationInfo(a, c));
        }

        // dfs
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0, visited, 0);
        // result
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void dfs(int cur, long totalDistance, boolean[] visited, int count) {
        if (count < n) {
            result = Math.max(totalDistance, result);
            for (DestinationInfo next : graph.get(cur)) {
                if (!visited[next.destination]) {
                    visited[next.destination] = true;
                    dfs(next.destination, totalDistance + next.distance, visited, count + 1);
                }
            }
        }
    }

    static class DestinationInfo {
        int destination;
        long distance;

        public DestinationInfo(int destination, long distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }
}
