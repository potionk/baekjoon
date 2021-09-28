package bj2602;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] roll = br.readLine().toCharArray();
        char[] angel = br.readLine().toCharArray();
        char[][] angelAndDemon = new char[2][angel.length];
        System.arraycopy(angel, 0, angelAndDemon[0], 0, angel.length);
        angelAndDemon[1] = br.readLine().toCharArray();
        int[][][] dp = new int[roll.length][2][angel.length];
        for (int i = 0; i < 2; i++) {
            if (angelAndDemon[i][0] == roll[0]) {
                dp[0][i][0] = 1;
            }
        }
        for (int i = 1; i < angel.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < roll.length; k++) {
                    if (k == 0) {
                        if (angelAndDemon[j][i] == roll[k]) {
                            dp[k][j][i] = dp[k][j][i - 1] + 1;
                        } else {
                            dp[k][j][i] = Math.max(dp[k][j][i], dp[k][j][i - 1]);
                        }
                    } else {
                        if (angelAndDemon[j][i] == roll[k] && dp[k - 1][(j + 1) % 2][i - 1] > 0) {
                            dp[k][j][i] = Math.max(dp[k - 1][(j + 1) % 2][i - 1] + dp[k][j][i - 1], dp[k][j][i - 1] + 1);
                        } else {
                            dp[k][j][i] = Math.max(dp[k][j][i], dp[k][j][i - 1]);
                        }
                    }
                }
            }
        }
        bw.write((dp[roll.length - 1][0][angel.length - 1] + dp[roll.length - 1][1][angel.length - 1]) + "");
        br.close();
        bw.close();
    }
}
