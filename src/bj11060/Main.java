package bj11060;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        for (int i = 1; i < n; i++) {
            dp[i] = 1000000;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j < n) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        if (dp[n - 1] != 1000000) {
            bw.write(dp[n - 1] + "");
        } else {
            bw.write("-1");
        }
        br.close();
        bw.close();
    }
}
