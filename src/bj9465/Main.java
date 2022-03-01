package bj9465;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n][3]; // 0: 윗줄, 1: 아랫줄, 2: 아무것도 x
            int[][] stickers = new int[2][n];
            for (int a = 0; a < 2; a++) {
                String[] readLine = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    stickers[a][i] = Integer.parseInt(readLine[i]);
                }
            }
            dp[0][0] = stickers[0][0];
            dp[0][1] = stickers[1][0];
            for (int i = 1; i < n; i++) {
                for (int a = 0; a < 3; a++) {
                    switch (a) {
                        case 0 -> dp[i][a] = Math.max(dp[i - 1][1], dp[i - 1][2]) + stickers[a][i];
                        case 1 -> dp[i][a] = Math.max(dp[i - 1][0], dp[i - 1][2]) + stickers[a][i];
                        case 2 -> dp[i][a] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
                    }
                }
            }
            bw.write(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]) + "\n");
        }
        br.close();
        bw.close();
    }
}
