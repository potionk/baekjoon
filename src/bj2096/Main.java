package bj2096;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[][] map = new int[tc][3];
        for (int i = 0; i < tc; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int[][] maxDp = new int[2][3];
        int[][] minDp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = map[0][i];
            minDp[0][i] = map[0][i];
        }
        for (int i = 1; i < tc; i++) {
            for (int j = 0; j < 3; j++) {
                int max = -1;
                int min = Integer.MAX_VALUE;
                for (int k = -1; k < 2; k++) {
                    if (j + k >= 0 && j + k < 3) {
                        max = Math.max(max, maxDp[0][j + k] + map[i][j]);
                        min = Math.min(min, minDp[0][j + k] + map[i][j]);
                    }
                }
                maxDp[1][j] = max;
                minDp[1][j] = min;
            }
            updateDpArray(maxDp, minDp);
        }
        int max = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, maxDp[0][i]);
            min = Math.min(min, minDp[0][i]);
        }
        bw.write(max + " " + min);
        br.close();
        bw.close();
    }

    public static void updateDpArray(int[][] maxDp, int[][] minDp) {
        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = maxDp[1][i];
            minDp[0][i] = minDp[1][i];
        }
    }
}
