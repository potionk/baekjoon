package bj17391;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {1, 0}, Y_ARROW = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] readline = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(readline[j]);
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int a = 1; a <= map[i][j]; a++) {
                        int nextX = j + a * X_ARROW[k];
                        int nextY = i + a * Y_ARROW[k];
                        if (nextX < M && nextY < N) {
                            dp[nextY][nextX] = Math.min(dp[i][j] + 1, dp[nextY][nextX]);
                        }
                    }
                }
            }
        }
        bw.write(dp[N - 1][M - 1] + "");
        br.close();
        bw.close();
    }
}
