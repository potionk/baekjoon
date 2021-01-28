package bj13565;

import java.io.*;

public class Main {
    static int[] xArrow, yArrow;
    static boolean isSuccess;

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
        for (int i = 0; i < xSize; i++) {
            if (!isSuccess && map[0][i] == '0') {
                dfs(0, i, map, isVisited, ySize, xSize);
            }
        }
        bw.write(isSuccess ? "YES" : "NO");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, char[][] map, boolean[][] isVisited, int ySize, int xSize) {
        isVisited[y][x] = true;
        if (y == ySize - 1) {
            isSuccess = true;
        } else {
            for (int i = 0; i < 4; i++) {
                int nextY = y + yArrow[i];
                int nextX = x + xArrow[i];
                if (nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && !isVisited[nextY][nextX] && map[nextY][nextX] == '0') {
                    dfs(nextY, nextX, map, isVisited, ySize, xSize);
                }
            }
        }
    }
}
