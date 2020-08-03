package bj4609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[68];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 68; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
        }
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int tc = Integer.parseInt(br.readLine());
            System.out.println(dp[tc]);
        }
    }
}
