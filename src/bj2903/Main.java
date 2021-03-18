package bj2903;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[15];
        dp[0] = 3;
        for (int i = 1; i < 15; i++) {
            dp[i] = dp[i - 1] * 2 - 1;
        }
        bw.write((int) Math.pow(dp[Integer.parseInt(br.readLine()) - 1], 2) + "");
        br.close();
        bw.close();
    }
}
