package bj16568;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nab = br.readLine().split(" ");
        int n = Integer.parseInt(nab[0]);
        int a = Integer.parseInt(nab[1]);
        int b = Integer.parseInt(nab[2]);
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            if (i - a >= 1) {
                dp[i] = Math.min(dp[i], dp[i - a - 1] + 1);
            }
            if (i - b >= 1) {
                dp[i] = Math.min(dp[i], dp[i - b - 1] + 1);
            }
        }
        bw.write(dp[n] + "");
        br.close();
        bw.close();
    }
}
