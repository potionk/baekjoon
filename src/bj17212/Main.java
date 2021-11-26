package bj17212;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 10000000;
        }
        int[] coin = {7, 5, 2, 1};
        for (int i = 1; i <= n; i++) {
            for (int c : coin) {
                if (c <= i) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        bw.write(dp[n] + "");
        br.close();
        bw.close();
    }
}
