package bj12849;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        long[] dp = {1, 0, 0, 0, 0, 0, 0, 0};
        while (tc-- > 0) {
            dp = move(dp);
        }
        bw.write(dp[0] + "");
        br.close();
        bw.close();
    }

    public static long[] move(long[] dp) {
        long[] nextDp = new long[8];
        nextDp[0] = (dp[1] + dp[2]) % 1000000007;
        nextDp[1] = (dp[0] + dp[2] + dp[3]) % 1000000007;
        nextDp[2] = (dp[0] + dp[1] + dp[3] + dp[4]) % 1000000007;
        nextDp[3] = (dp[1] + dp[2] + dp[4] + dp[5]) % 1000000007;
        nextDp[4] = (dp[2] + dp[3] + dp[5] + dp[6]) % 1000000007;
        nextDp[5] = (dp[3] + dp[4] + dp[7]) % 1000000007;
        nextDp[6] = (dp[4] + dp[7]) % 1000000007;
        nextDp[7] = (dp[5] + dp[6]) % 1000000007;
        return nextDp;
    }
}
