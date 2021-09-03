package bj2636;

import java.io.*;
import java.util.Arrays;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};
    static int cheeseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        int ySize = Integer.parseInt(size[0]);
        int xSize = Integer.parseInt(size[1]);
        int[][] map = new int[ySize][xSize];
        cheeseCount = 0;
        for (int i = 0; i < ySize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
                if (map[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }
        int result = 0;
        while (true) {
            result++;
            int[][] originMap = arrayCopy(map);
            int beforeCheeseCount = cheeseCount;
            dfs(originMap, map, new boolean[ySize][xSize], ySize, xSize, 0, 0);
            if (cheeseCount == 0) {
                bw.write(result + "\n" + beforeCheeseCount);
                br.close();
                bw.close();
                return;
            }
        }
    }

    public static void dfs(int[][] originMap, int[][] map, boolean[][] isVisited, int ySize, int xSize, int y, int x) {
        for (int k = 0; k < 4; k++) {
            int nextY = y + Y_ARROW[k];
            int nextX = x + X_ARROW[k];
            if (isValidatedPoint(nextY, nextX, ySize, xSize) && !isVisited[nextY][nextX]) {
                if (map[nextY][nextX] == 1) {
                    cheeseCount--;
                    map[nextY][nextX] = 0;
                }
                if (originMap[nextY][nextX] == 0) {
                    isVisited[nextY][nextX] = true;
                    dfs(originMap, map, isVisited, ySize, xSize, nextY, nextX);
                }
            }
        }
    }

    public static int[][] arrayCopy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
    }
}
