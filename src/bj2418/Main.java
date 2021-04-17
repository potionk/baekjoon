package bj2418;

import java.io.*;

public class Main {
    static final int[] xArrow = {1, 0, -1, 0, 1, 1, -1, -1};
    static final int[] yArrow = {0, -1, 0, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] HWL = br.readLine().split(" ");
        int H = Integer.parseInt(HWL[0]);
        int W = Integer.parseInt(HWL[1]);
        int L = Integer.parseInt(HWL[2]);
        char[][] map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String readline = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = readline.charAt(j);
            }
        }
        char[] word = br.readLine().toCharArray();
        int wordLen = word.length;
        long[][][] dp = new long[H][W][L + 1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (word[0] == map[i][j]) {
                    dp[i][j][0] = 1;
                }
            }
        }
        long count = 0;
        for (int a = 0; a < L - 1; a++) {
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (dp[i][j][a] > 0) {
                        for (int k = 0; k < 8; k++) {
                            int nextY = i + yArrow[k];
                            int nextX = j + xArrow[k];
                            if (nextX >= 0 && nextX < W && nextY >= 0 && nextY < H) {
                                if (map[nextY][nextX] == word[a + 1]) {
                                    if (a + 1 == wordLen - 1) {
                                        count += dp[i][j][a];
                                    } else {
                                        dp[nextY][nextX][a + 1] += dp[i][j][a];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        bw.write(count + "");
        br.close();
        bw.close();
    }
}
