package bj1987;

import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] isVisited;
    static int xSize, ySize, max;
    static boolean[] isAlphabetUsed;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        xSize = Integer.parseInt(input[1]);
        ySize = Integer.parseInt(input[0]);
        map = new int[ySize][xSize];
        isVisited = new boolean[ySize][xSize];
        isAlphabetUsed = new boolean[26];
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        for (int i = 0; i < ySize; i++) {
            char[] read = br.readLine().toCharArray();
            for (int j = 0; j < xSize; j++) {
                map[i][j] = (int) read[j] - 65;
            }
        }
        dfs(0, 0, 1);
        bw.write(max + "");
        bw.close();
        br.close();
    }

    public static void dfs(int y, int x, int count) {
        isVisited[y][x] = true;
        isAlphabetUsed[map[y][x]] = true;
        max = Math.max(count, max);
        for (int i = 0; i < 4; i++) {
            int nextX = x + xArrow[i];
            int nextY = y + yArrow[i];
            if (0 <= nextX && 0 <= nextY && nextX < xSize && nextY < ySize && !isAlphabetUsed[map[nextY][nextX]] && !isVisited[nextY][nextX]) {
                dfs(nextY, nextX, count + 1);
            }
        }
        isAlphabetUsed[map[y][x]] = false;
        isVisited[y][x] = false;
    }
}