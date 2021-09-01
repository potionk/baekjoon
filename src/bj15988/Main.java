package bj15988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] input = new int[T];
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, input[i]);
        }
        long[] dp = new long[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = (dp[3] + dp[1] + dp[2] + dp[2] + dp[1] + dp[3]) - 7;
        for (int i = 5; i <= max; i++) {
            dp[i] = ((dp[i - 1] + dp[1] + dp[i - 2] + dp[2] + dp[i - 3] + dp[3]) - 7) % 1000000009;
        }
        for (int i : input) {
            bw.write(dp[i] + "\n");
        }
        br.close();
        bw.close();
    }
}