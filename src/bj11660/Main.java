package bj11660;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] table = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int[][] dp = new int[N][N];
        dp[0][0] = table[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + table[i][0];
            dp[0][i] = dp[0][i - 1] + table[0][i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + table[i][j];
            }
        }
        while (M-- > 0) {
            String[] info = br.readLine().split(" ");
            int y1 = Integer.parseInt(info[0]) - 1;
            int x1 = Integer.parseInt(info[1]) - 1;
            int y2 = Integer.parseInt(info[2]) - 1;
            int x2 = Integer.parseInt(info[3]) - 1;
            int result = dp[y2][x2];
            if (y1 > 0) {
                result -= dp[y1 - 1][x2];
            }
            if (x1 > 0) {
                result -= dp[y2][x1 - 1];
            }
            if (y1 > 0 && x1 > 0) {
                result += dp[y1 - 1][x1 - 1];
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}