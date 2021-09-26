package bj21938;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int ySize = Integer.parseInt(nm[0]);
        int xSize = Integer.parseInt(nm[1]);
        int[][] map = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < xSize * 3; j += 3) {
                map[i][j / 3] = Integer.parseInt(readLine[j]) + Integer.parseInt(readLine[j + 1]) + Integer.parseInt(readLine[j + 2]);
            }
        }
        int T = Integer.parseInt(br.readLine()) * 3;
        boolean[][] visited = new boolean[ySize][xSize];
        int result = 0;
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (map[i][j] >= T && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, map, visited, T, ySize, xSize);
                    result++;
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int[][] map, boolean[][] visited, int T, int ySize, int xSize) {
        for (int i = 0; i < 4; i++) {
            int nextY = y + Y_ARROW[i];
            int nextX = x + X_ARROW[i];
            if (isValidatedPoint(nextY, nextX, ySize, xSize) && map[nextY][nextX] >= T && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                dfs(nextY, nextX, map, visited, T, ySize, xSize);
            }
        }
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
    }
}
