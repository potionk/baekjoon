package bj4097;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N;
        while (!(N = br.readLine()).equals("0")) {
            int n = Integer.parseInt(N);
            int[] profit = new int[n];
            for (int i = 0; i < n; i++) {
                profit[i] = Integer.parseInt(br.readLine());
            }
            int[] dp = new int[n];
            dp[0] = profit[0];
            int result = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + profit[i], profit[i]);
                result = Math.max(result, dp[i]);
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}