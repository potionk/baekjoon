package bj2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        int tcLen = tc.length();
        int[] dp = new int[tcLen + 1];
        dp[0] = 1;
        for (int i = 1; i <= tcLen; i++) {
            if (tc.charAt(i - 1) != '0') {
                dp[i] = (dp[i] + dp[i - 1]) % 1000000;
            }
            if (i - 2 >= 0) {
                int t = Integer.parseInt(tc.substring(i - 2, i));
                if (t >= 10 && t <= 26) {
                    dp[i] = (dp[i] + dp[i - 2]) % 1000000;
                }
            }
        }
        System.out.println(dp[tcLen]);
    }
}