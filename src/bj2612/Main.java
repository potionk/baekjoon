package bj2612;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] xArrow = new int[]{1, 0, 1};
        int[] yArrow = new int[]{1, 1, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ALen = Integer.parseInt(br.readLine());
        char[] A = br.readLine().toCharArray();
        int BLen = Integer.parseInt(br.readLine());
        char[] B = br.readLine().toCharArray();
        Data[][] dp = new Data[ALen][BLen];
        for (int i = 0; i < ALen; i++) {
            for (int j = 0; j < BLen; j++) {
                int score = A[i] == B[j] ? 3 : -2;
                if (i == 0 && j == 0) {
                    dp[i][j] = new Data(-1, -1, score);
                } else {
                    if (dp[i][j].score < score) {
                        dp[i][j] = new Data(-1, -1, score);
                    } else {
                        score = dp[i][j].score;
                    }
                }
                for (int k = 0; k < 3; k++) {
                    int nextY = i + yArrow[k];
                    int nextX = j + xArrow[k];
                    if (nextY < ALen && nextX < BLen) {
                        int nextScore = score + (A[nextY] == B[nextX] ? 3 : -2);
                        if (dp[nextY][nextX] == null) {
                            if (k == 0) {
                                dp[nextY][nextX] = new Data(i, j, nextScore);
                            } else {
                                dp[nextY][nextX] = new Data(i, j, score - 2);
                            }
                        } else {
                            int nextBeforeScore = dp[nextY][nextX].score;
                            if (k == 0) {
                                if (nextBeforeScore < nextScore) {
                                    dp[nextY][nextX] = new Data(i, j, nextScore);
                                }
                            } else {
                                if (nextBeforeScore < score - 2) {
                                    dp[nextY][nextX] = new Data(i, j, score - 2);
                                }
                            }
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int y = 0, x = 0;
        for (int i = 0; i < ALen; i++) {
            for (int j = 0; j < BLen; j++) {
                if (max < dp[i][j].score) {
                    max = dp[i][j].score;
                    y = i;
                    x = j;
                }
            }
        }
        bw.write(max + "\n");
        StringBuilder AResult = new StringBuilder();
        StringBuilder BResult = new StringBuilder();
        int finishY = y, finishX = x;
        while (true) {
            if (dp[y][x].beforeY == -1 && dp[y][x].beforeX == -1) {
                break;
            } else {
                int tempY = dp[y][x].beforeY;
                x = dp[y][x].beforeX;
                y = tempY;
            }
        }
        for (int i = y; i <= finishY; i++) {
            AResult.append(A[i]);
        }
        for (int i = x; i <= finishX; i++) {
            BResult.append(B[i]);
        }
        bw.write(AResult.toString() + "\n");
        bw.write(BResult.toString());
        br.close();
        bw.close();
    }

    private static class Data {
        int beforeY;
        int beforeX;
        int score;

        public Data(int beforeY, int beforeX, int score) {
            this.beforeY = beforeY;
            this.beforeX = beforeX;
            this.score = score;
        }
    }
}
