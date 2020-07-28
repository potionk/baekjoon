package bj11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] graph, dp;
    static int xSize, ySize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        ySize = Integer.parseInt(size[0]);
        xSize = Integer.parseInt(size[1]);
        graph = new int[ySize + 1][xSize + 1];
        dp = new int[ySize + 1][xSize + 1];
        for (int i = 1; i <= ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= xSize; j++) {
                graph[i][j] = Integer.parseInt(input[j - 1]);
            }
        }
        for (int i = 1; i < ySize + 1; i++) {
            for (int j = 1; j < xSize + 1; j++) {
                dp[i][j] = Math.max(graph[i][j] + dp[i - 1][j], graph[i][j] + dp[i][j - 1]);
            }
        }
        System.out.println(dp[ySize][xSize]);
    }
}