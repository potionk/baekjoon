package bj9657;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N == 1 || N == 3 || N == 4) {
            bw.write("SK");
        } else if (N == 2) {
            bw.write("CY");
        } else {
            boolean[] dp = new boolean[N + 1];
            dp[1] = true; // 상근 이김
            dp[2] = false; // 못이김
            dp[3] = true;
            dp[4] = true;
            for (int i = 5; i < N + 1; i++) {
                dp[i] = !(dp[i - 4] && dp[i - 3] && dp[i - 1]); // 하나라도 false가 있으면 상근이 이길 수 있음
            }
            bw.write(dp[N] ? "SK" : "CY");
        }
        br.close();
        bw.close();
    }
}