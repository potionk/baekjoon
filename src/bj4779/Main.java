package bj4779;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        String[] dp = new String[13];
        dp = init(dp);
        while ((input = br.readLine()) != null) {
            bw.write(dp[Integer.parseInt(input)] + "\n");
        }
        br.close();
        bw.close();
    }

    public static String[] init(String[] dp) {
        dp[0] = "-";
        for (int i = 1; i < 13; i++) {
            dp[i] = dp[i - 1] + makeBlank(dp[i - 1].length()) + dp[i - 1];
        }
        return dp;
    }

    public static String makeBlank(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
