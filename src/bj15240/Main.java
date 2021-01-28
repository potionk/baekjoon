package bj15240;

import java.io.*;

public class Main {
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        String[] info = br.readLine().split(" ");
        int ySize = Integer.parseInt(info[0]);
        int xSize = Integer.parseInt(info[1]);
        char[][] map = new char[ySize][xSize];
        boolean[][] isVisited = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String readline = br.readLine();
            for (int j = 0; j < xSize; j++) {
                map[i][j] = readline.charAt(j);
            }
        }
        String[] target = br.readLine().split(" ");
        int targetY = Integer.parseInt(target[0]);
        int targetX = Integer.parseInt(target[1]);
        dfs(targetY, targetX, target[2].charAt(0), map[targetY][targetX], map, isVisited, ySize, xSize);
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, char paintColor, char beforeColor, char[][] map, boolean[][] isVisited, int ySize, int xSize) {
        isVisited[y][x] = true;
        map[y][x] = paintColor;
        for (int i = 0; i < 4; i++) {
            int nextY = y + yArrow[i];
            int nextX = x + xArrow[i];
            if (nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && !isVisited[nextY][nextX] && map[nextY][nextX] == beforeColor) {
                dfs(nextY, nextX, paintColor, beforeColor, map, isVisited, ySize, xSize);
            }
        }
    }
}