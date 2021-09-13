package bj17144;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] RCT = br.readLine().split(" ");
        int R = Integer.parseInt(RCT[0]);
        int C = Integer.parseInt(RCT[1]);
        int T = Integer.parseInt(RCT[2]);
        int[][] map = new int[R][C];
        Point cleanerBottom = null, cleanerTop = null;
        boolean isCleanerFind = false;
        for (int i = 0; i < R; i++) {
            String[] readline = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(readline[j]);
                if (map[i][j] == -1) {
                    if (!isCleanerFind) {
                        cleanerTop = new Point(i, j);
                        isCleanerFind = true;
                    } else {
                        cleanerBottom = new Point(i, j);
                    }
                }
            }
        }
        while (T-- > 0) {
            map = spread(map, R, C);
            clean(map, R, C, cleanerTop, cleanerBottom);
        }
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    result += map[i][j];
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void clean(int[][] map, int ySize, int xSize, Point cleanerTop, Point cleanerBottom) {
        for (int i = cleanerTop.y - 2; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }
        for (int i = 0; i < xSize - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < cleanerTop.y; i++) {
            map[i][xSize - 1] = map[i + 1][xSize - 1];
        }
        for (int i = xSize - 1; i >= 2; i--) {
            map[cleanerTop.y][i] = map[cleanerTop.y][i - 1];
        }
        map[cleanerTop.y][1] = 0;

        for (int i = cleanerBottom.y + 1; i < ySize - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < xSize - 1; i++) {
            map[ySize - 1][i] = map[ySize - 1][i + 1];
        }
        for (int i = ySize - 1; i >= cleanerBottom.y; i--) {
            map[i][xSize - 1] = map[i - 1][xSize - 1];
        }
        for (int i = xSize - 1; i >= 2; i--) {
            map[cleanerBottom.y][i] = map[cleanerBottom.y][i - 1];
        }
        map[cleanerBottom.y][1] = 0;
    }

    public static int[][] spread(int[][] map, int ySize, int xSize) {
        int[][] newMap = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (map[i][j] == -1) {
                    newMap[i][j] = -1;
                } else if (map[i][j] > 0) {
                    int count = 0;
                    int spreadAmount = map[i][j] / 5;
                    for (int n = 0; n < 4; n++) {
                        int nextY = i + Y_ARROW[n];
                        int nextX = j + X_ARROW[n];
                        if (isValidatedPoint(nextY, nextX, ySize, xSize) && map[nextY][nextX] != -1) {
                            newMap[nextY][nextX] += spreadAmount;
                            count++;
                        }
                    }
                    newMap[i][j] += map[i][j] - (count * spreadAmount);
                }
            }
        }
        return newMap;
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
    }

    private static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
