package bj14430;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        int xSize = Integer.parseInt(size[1]);
        int ySize = Integer.parseInt(size[0]);
        int[][] map = new int[ySize][xSize];
        int[][] dp = new int[ySize][xSize];
        int[] xArrow = {-1, 0}, yArrow = {0, -1};
        for (int i = 0; i < ySize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                int max = 0;
                for (int k = 0; k < 2; k++) {
                    if (i + yArrow[k] >= 0 && j + xArrow[k] >= 0) {
                        max = Math.max(max, map[i + yArrow[k]][j + xArrow[k]]);
                    }
                }
                map[i][j] += max;
            }
        }
        bw.write(map[ySize - 1][xSize - 1] + "");
        br.close();
        bw.close();
    }
}
