package bj2638;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static final int[] X_ARROW = {1, 0, -1, 0}, Y_ARROW = {0, -1, 0, 1};
    static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        int ySize = Integer.parseInt(size[0]);
        int xSize = Integer.parseInt(size[1]);
        int[][] map = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(readLine[j]) * 2;
            }
        }
        int result = 0;
        while (true) {
            result++;
            map = bfs(0, 0, map, ySize, xSize);
            if (isFinish) {
                bw.write((result - 1) + "");
                br.close();
                bw.close();
                return;
            } else {
                for (int i = 0; i < ySize; i++) {
                    for (int j = 0; j < xSize; j++) {
                        if (map[i][j] > 0) {
                            map[i][j] = 2;
                        }
                    }
                }
            }
        }
    }

    public static int[][] arrayCopy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
    }

    public static int[][] bfs(int y, int x, int[][] originMap, int ySize, int xSize) {
        int zeroPointCount = 0;
        int[][] map = arrayCopy(originMap);
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(y, x));
        boolean[][] isVisited = new boolean[ySize][xSize];
        isVisited[y][x] = true;
        while (queue.size() != 0) {
            Point next = queue.poll();
            y = next.getY();
            x = next.getX();
            if (originMap[y][x] == 0) {
                zeroPointCount++;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = y + Y_ARROW[i];
                int nextX = x + X_ARROW[i];
                if (nextY < ySize && nextX < xSize && nextY >= 0 && nextX >= 0) {
                    if (originMap[nextY][nextX] > 0) {
                        map[nextY][nextX]--;
                        if (map[nextY][nextX] < 0) {
                            map[nextY][nextX] = 0;
                        }
                    }
                    if (originMap[nextY][nextX] == 0 && !isVisited[nextY][nextX]) {
                        queue.add(new Point(nextY, nextX));
                        isVisited[nextY][nextX] = true;
                    }
                }
            }
        }
        if (zeroPointCount == ySize * xSize) {
            isFinish = true;
        }
        return map;
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}