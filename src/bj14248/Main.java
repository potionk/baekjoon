package bj14248;

import java.io.*;

public class Main {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n];
        String[] aiStr = br.readLine().split(" ");
        int[] ai = new int[n];
        for (int i = 0; i < n; i++) {
            ai[i] = Integer.parseInt(aiStr[i]);
        }
        int start = Integer.parseInt(br.readLine()) - 1;
        visited[start] = true;
        dfs(start, ai, visited, n);
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void dfs(int point, int[] ai, boolean[] visited, int n) {
        result++;
        if (point + ai[point] < n && !visited[point + ai[point]]) {
            visited[point + ai[point]] = true;
            dfs(point + ai[point], ai, visited, n);
        }
        if (point - ai[point] >= 0 && !visited[point - ai[point]]) {
            visited[point - ai[point]] = true;
            dfs(point - ai[point], ai, visited, n);
        }
    }
}
