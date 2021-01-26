package bj14495;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n <= 3) {
            bw.write("1");
        } else {
            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 3];
            }
            bw.write(dp[n] + "");
        }
        br.close();
        bw.close();
    }
}
