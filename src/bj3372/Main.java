package bj3372;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static final int[] X_ARROW = {1, 0}, Y_ARROW = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        BigInteger[][] dp = new BigInteger[N][N];
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
                dp[i][j] = BigInteger.ZERO;
            }
        }
        dp[0][0] = BigInteger.ONE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j].compareTo(BigInteger.ZERO) != 0) {
                    for (int k = 0; k < 2; k++) {
                        if (map[i][j] != 0) {
                            int nextX = j + map[i][j] * X_ARROW[k];
                            int nextY = i + map[i][j] * Y_ARROW[k];
                            if (nextX < N && nextY < N) {
                                dp[nextY][nextX] = dp[i][j].add(dp[nextY][nextX]);
                            }
                        }
                    }
                }
            }
        }
        bw.write(dp[N - 1][N - 1] + "");
        br.close();
        bw.close();
    }
}