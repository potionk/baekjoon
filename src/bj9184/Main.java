package bj9184;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][][] dp = new int[21][21][21];
        while (true) {
            String[] abc = br.readLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            dp = init(dp);
            int result;
            if (a <= 0 || b <= 0 || c <= 0) {
                result = w(0, 0, 0, dp);
            } else if (a > 20 || b > 20 || c > 20) {
                result = w(20, 20, 20, dp);
            } else {
                result = w(a, b, c, dp);
            }
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
        }
        br.close();
        bw.close();
    }

    public static int w(int a, int b, int c, int[][][] dp) {
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1, dp) + w(a, b - 1, c - 1, dp) - w(a, b - 1, c, dp);
        } else {
            return dp[a][b][c] = w(a - 1, b, c, dp) + w(a - 1, b - 1, c, dp) + w(a - 1, b, c - 1, dp) - w(a - 1, b - 1, c - 1, dp);
        }
    }

    public static int[][][] init(int[][][] dp) {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 21; i++) {
                for (int j = 0; j < 21; j++) {
                    switch (k) {
                        case 0:
                            dp[0][i][j] = 1;
                            break;
                        case 1:
                            dp[i][0][j] = 1;
                            break;
                        case 2:
                            dp[i][j][0] = 1;
                            break;
                    }
                }
            }
        }
        return dp;
    }
}
