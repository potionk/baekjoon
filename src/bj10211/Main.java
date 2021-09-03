package bj10211;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] arrStr = br.readLine().split(" ");
            int[] arr = new int[N];
            int[] dp = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            dp[0] = arr[0];
            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            }
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                result = Math.max(dp[i], result);
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
