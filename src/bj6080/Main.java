package bj6080;

import java.io.*;

public class Main {
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0, 1, 1, -1, -1};
        yArrow = new int[]{0, -1, 0, 1, 1, -1, 1, -1};
        String[] info = br.readLine().split(" ");
        int ySize = Integer.parseInt(info[0]);
        int xSize = Integer.parseInt(info[1]);
        int[][] map = new int[ySize][xSize];
        boolean[][] isVisited = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String[] readline = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(readline[j]);
            }
        }
        int result = 0;
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (map[i][j] > 0 && !isVisited[i][j]) {
                    result++;
                    dfs(i, j, map, isVisited, ySize, xSize);
                }
            }
        }
        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int[][] map, boolean[][] isVisited, int ySize, int xSize) {
        isVisited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int nextY = y + yArrow[i];
            int nextX = x + xArrow[i];
            if (nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && !isVisited[nextY][nextX] && map[nextY][nextX] > 0) {
                dfs(nextY, nextX, map, isVisited, ySize, xSize);
            }
        }
    }
}