package bj15990;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        int max = -1;
        int[] tc = new int[tcNum];
        for (int i = 0; i < tcNum; i++) {
            tc[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, tc[i]);
        }
        int[][] dp = new int[4][max + 1];
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[1][3] = 1; // 2+1
        dp[2][3] = 1; // 1+2
        dp[3][3] = 1; // 3

        for (int i = 4; i <= max; i++) {
            for (int k = 1; k < 4; k++) {
                for (int j = 1; j < 4; j++) {
                    if (j != k) {
                        dp[k][i] += dp[j][i - k];
                        dp[k][i] %= 1000000009;
                    }
                }
            }
        }
        for (int i = 0; i < tcNum; i++) {
            long result = 0;
            for (int j = 1; j < 4; j++) {
                result += dp[j][tc[i]];
                result %= 1000000009;
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
