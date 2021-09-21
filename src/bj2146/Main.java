package bj2146;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int[] X_ARROW = {1, 0, -1, 0}, Y_ARROW = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int value = 1;
        boolean[][] isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    dfs(i, j, N, map, isVisited, value);
                    value++;
                }
            }
        }
        Queue<Point> borderQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    boolean isBorderPoint = false;
                    for (int k = 0; k < 4; k++) {
                        int nextY = Y_ARROW[k] + i;
                        int nextX = X_ARROW[k] + j;
                        if (isValidatedPoint(nextY, nextX, N) && map[nextY][nextX] == 0) {
                            isBorderPoint = true;
                            break;
                        }
                    }
                    if (isBorderPoint) {
                        borderQueue.add(new Point(i, j, 0));
                    }
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        while (!borderQueue.isEmpty()) {
            Point p = borderQueue.poll();
            answer = Math.min(bfs(p.y, p.x, N, map), answer);
        }
        bw.write(answer + "");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int size, int[][] map, boolean[][] isVisited, int value) {
        map[y][x] = value;
        for (int i = 0; i < 4; i++) {
            int nextY = Y_ARROW[i] + y;
            int nextX = X_ARROW[i] + x;
            if (isValidatedPoint(nextY, nextX, size) && !isVisited[nextY][nextX] && map[nextY][nextX] == 1) {
                isVisited[nextY][nextX] = true;
                dfs(nextY, nextX, size, map, isVisited, value);
            }
        }
    }

    public static int bfs(int y, int x, int size, int[][] map) {
        int startIsland = map[y][x];
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(y, x, 0));
        boolean[][] isVisited = new boolean[size][size];
        isVisited[y][x] = true;
        while (queue.size() != 0) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = p.y + Y_ARROW[i];
                int nextX = p.x + X_ARROW[i];
                if (isValidatedPoint(nextY, nextX, size) && !isVisited[nextY][nextX]) {
                    if (map[nextY][nextX] == 0) {
                        queue.add(new Point(nextY, nextX, p.distance + 1));
                        isVisited[nextY][nextX] = true;
                    } else if (map[nextY][nextX] != startIsland) {
                        return p.distance;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int n) {
        return !(nextY >= n) && !(nextX >= n) && !(nextY < 0) && !(nextX < 0);
    }

    private static class Point {
        int y;
        int x;
        int distance;

        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
