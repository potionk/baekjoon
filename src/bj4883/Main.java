package bj4883;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcCount = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            long[][] dp = new long[N][3];
            for (int i = 0; i < N; i++) {
                String[] readline = br.readLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Long.parseLong(readline[j]);
                }
            }
            dp[0][0] = Integer.MAX_VALUE;
            dp[0][2] += dp[0][1];
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (j) {
                        case 0 -> dp[i][j] += Math.min(dp[i - 1][0], dp[i - 1][1]);
                        case 1 -> dp[i][j] += Math.min(Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]), dp[i][0]);
                        case 2 -> dp[i][j] += Math.min(Math.min(dp[i - 1][1], dp[i - 1][2]), dp[i][1]);
                    }
                }
            }
            bw.write((tcCount++) + ". " + dp[N - 1][1] + "\n");
        }
        br.close();
        bw.close();
    }
}
