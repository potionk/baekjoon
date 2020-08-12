package bj1964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int[] dp = new int[tc];
        dp[0] = 5;
        int plus = 7;
        for (int i = 1; i < tc; i++) {
            dp[i] = (dp[i - 1] + plus) % 45678;
            plus += 3;
        }
        System.out.println(dp[tc-1]);
    }
}
