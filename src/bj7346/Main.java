package bj7346;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] xArrow = new int[]{-1, 0, -1};
        int[] yArrow = new int[]{-1, -1, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] AInfo = br.readLine().split(" ");
            int ALen = Integer.parseInt(AInfo[0]);
            char[] A = AInfo[1].toCharArray();
            String[] BInfo = br.readLine().split(" ");
            int BLen = Integer.parseInt(BInfo[0]);
            char[] B = BInfo[1].toCharArray();
            long[][] dp = new long[ALen + 1][BLen + 1];
            for (int i = 1; i < ALen + 1; i++) {
                for (int j = 1; j < BLen + 1; j++) {
                    dp[i][j] = Long.MIN_VALUE;
                }
            }
            for (int i = 1; i < ALen + 1; i++) {
                dp[i][0] = dp[i - 1][0] + getBlankWeight(A[i - 1]);
            }
            for (int i = 1; i < BLen + 1; i++) {
                dp[0][i] = dp[0][i - 1] + getBlankWeight(B[i - 1]);
            }
            for (int i = 1; i < ALen + 1; i++) {
                for (int j = 1; j < BLen + 1; j++) {
                    for (int k = 0; k < 3; k++) {
                        int nextY = i + yArrow[k];
                        int nextX = j + xArrow[k];
                        switch (k) {
                            case 0 -> dp[i][j] = Math.max(dp[i][j], dp[nextY][nextX] + getWeight(A[i - 1], B[j - 1]));
                            case 1 -> dp[i][j] = Math.max(dp[i][j], dp[nextY][nextX] + getBlankWeight(A[i - 1]));
                            case 2 -> dp[i][j] = Math.max(dp[i][j], dp[nextY][nextX] + getBlankWeight(B[j - 1]));
                        }
                    }
                }
            }
            bw.write(dp[ALen][BLen] + "\n");
        }
        br.close();
        bw.close();
    }

    public static int getWeight(char a, char b) {
        if (a == b) {
            return 5;
        }
        int total = a - 'A' + b - 'A';
        switch (total) {
            case 2, 19 -> {
                return -1;
            }
            case 6, 21, 25 -> {
                return -2;
            }
            case 8 -> {
                return -3;
            }
        }
        return -1337;
    }

    public static int getBlankWeight(char c) {
        switch (c) {
            case 'A' -> {
                return -3;
            }
            case 'C' -> {
                return -4;
            }
            case 'G' -> {
                return -2;
            }
            case 'T' -> {
                return -1;
            }
        }
        return -1337;
    }
}