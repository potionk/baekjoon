package bj2780;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] dp = new int[10];
            for (int i = 0; i < 10; i++) {
                dp[i] = 1;
            }
            int N = Integer.parseInt(br.readLine());
            while (N-- > 1) {
                dp = updateDp(dp);
            }
            int result = 0;
            for (int i : dp) {
                result += i % 1234567;
            }
            result %= 1234567;
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    public static int[] updateDp(int[] dp) {
        int[] nextDp = new int[10];
        nextDp[0] += (dp[7]) % 1234567;
        nextDp[1] += (dp[2] + dp[4]) % 1234567;
        nextDp[2] += (dp[1] + dp[3] + dp[5]) % 1234567;
        nextDp[3] += (dp[2] + dp[6]) % 1234567;
        nextDp[4] += (dp[1] + dp[5] + dp[7]) % 1234567;
        nextDp[5] += (dp[2] + dp[4] + dp[6] + dp[8]) % 1234567;
        nextDp[6] += (dp[3] + dp[5] + dp[9]) % 1234567;
        nextDp[7] += (dp[4] + dp[8] + dp[0]) % 1234567;
        nextDp[8] += (dp[5] + dp[9] + dp[7]) % 1234567;
        nextDp[9] += (dp[6] + dp[8]) % 1234567;
        return nextDp;
    }
}
