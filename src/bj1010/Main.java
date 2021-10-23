package bj1010;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] dp = new int[30][30];
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }
        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] readLine = br.readLine().split(" ");
            int left = Integer.parseInt(readLine[0]);
            int right = Integer.parseInt(readLine[1]);
            bw.write(dp[right][left] + "\n");
        }
        br.close();
        bw.close();
    }
}