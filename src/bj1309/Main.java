package bj1309;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0 -> dp[i][j] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
                    case 1 -> dp[i][j] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
                    case 2 -> dp[i][j] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
                }
            }
        }
        bw.write(((dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901) + "");
        br.close();
        bw.close();
    }
}