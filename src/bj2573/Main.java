package bj2573;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] xArrow, yArrow;
    static int count;
    static boolean isAllMelted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        String[] size = br.readLine().split(" ");
        int ySize = Integer.parseInt(size[0]);
        int xSize = Integer.parseInt(size[1]);
        int[][] map = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int result = 0;
        while (true) {
            result++;
            map = melt(map, ySize, xSize);
            if (isAllMelted) {
                bw.write("0");
                br.close();
                bw.close();
                return;
            }
            count = 0;
            boolean[][] isVisited = new boolean[ySize][xSize];
            for (int y = 0; y < ySize; y++) {
                for (int x = 0; x < xSize; x++) {
                    if (!isVisited[y][x] && map[y][x] != 0) {
                        count++;
                        dfs(map, isVisited, ySize, xSize, y, x);
                    }
                }
            }
            if (count > 1) {
                bw.write(result + "");
                br.close();
                bw.close();
                return;
            }
        }
    }

    public static void dfs(int[][] map, boolean[][] isVisited, int ySize, int xSize, int y, int x) {
        for (int k = 0; k < 4; k++) {
            if (x + xArrow[k] >= 0 && x + xArrow[k] < xSize && y + yArrow[k] >= 0 && y + yArrow[k] < ySize && map[y + yArrow[k]][x + xArrow[k]] != 0 && !isVisited[y + yArrow[k]][x + xArrow[k]]) {
                isVisited[y + yArrow[k]][x + xArrow[k]] = true;
                dfs(map, isVisited, ySize, xSize, y + yArrow[k], x + xArrow[k]);
            }
        }
    }

    public static int[][] melt(int[][] originMap, int ySize, int xSize) {
        int[][] map = arrayCopy(originMap);
        int meltCount = 0;
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (originMap[i][j] == 0) {
                    meltCount++;
                    for (int k = 0; k < 4; k++) {
                        if (j + xArrow[k] >= 0 && j + xArrow[k] < xSize && i + yArrow[k] >= 0 && i + yArrow[k] < ySize) {
                            map[i + yArrow[k]][j + xArrow[k]]--;
                            if (map[i + yArrow[k]][j + xArrow[k]] < 0) {
                                map[i + yArrow[k]][j + xArrow[k]] = 0;
                            }
                        }
                    }
                }
            }
        }
        if (meltCount == ySize * xSize) {
            isAllMelted = true;
        }
        return map;
    }

    public static int[][] arrayCopy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
    }
}
