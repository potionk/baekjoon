package bj1303;

import java.io.*;

public class Main {
    static int[] xArrow, yArrow;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        String[] info = br.readLine().split(" ");
        int ySize = Integer.parseInt(info[1]);
        int xSize = Integer.parseInt(info[0]);
        char[][] map = new char[ySize][xSize];
        boolean[][] isVisited = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String readline = br.readLine();
            for (int j = 0; j < xSize; j++) {
                map[i][j] = readline.charAt(j);
            }
        }
        int W = 0, B = 0;
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (!isVisited[i][j]) {
                    count = 0;
                    dfs(i, j, map, isVisited, ySize, xSize, map[i][j]);
                    if (map[i][j] == 'W') {
                        W += count * count;
                    } else {
                        B += count * count;
                    }
                }
            }
        }
        bw.write(W + " " + B + "");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, char[][] map, boolean[][] isVisited, int ySize, int xSize, char team) {
        isVisited[y][x] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nextY = y + yArrow[i];
            int nextX = x + xArrow[i];
            if (nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && !isVisited[nextY][nextX] && map[nextY][nextX] == team) {
                dfs(nextY, nextX, map, isVisited, ySize, xSize, team);
            }
        }
    }
}