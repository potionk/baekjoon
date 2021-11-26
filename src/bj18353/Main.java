package bj18353;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] soldierStr = br.readLine().split(" ");
        int[] soldier = new int[n];
        for (int i = 0; i < n; i++) {
            soldier[i] = Integer.parseInt(soldierStr[i]);
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (soldier[i] > soldier[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int max = -1;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        bw.write((n - max) + "");
        br.close();
        bw.close();
    }
}
