package bj1726;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static final int[] X_ARROW = {1, -1, 0, 0}, Y_ARROW = {0, 0, 1, -1};
    static final int[][] DIRECTION_ARROW = {{3, 2}, {2, 3}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        bw.write(bfs(map, br.readLine().split(" "), br.readLine().split(" ")) + "");
        br.close();
        bw.close();
    }

    public static int bfs(int[][] map, String[] startInfo, String[] destInfo) {
        int ySize = map.length, xSize = map[0].length;
        LinkedList<Point> queue = new LinkedList<>();
        int startY = Integer.parseInt(startInfo[0]) - 1, startX = Integer.parseInt(startInfo[1]) - 1, startDirection = Integer.parseInt(startInfo[2]) - 1;
        int destY = Integer.parseInt(destInfo[0]) - 1, destX = Integer.parseInt(destInfo[1]) - 1, destDirection = Integer.parseInt(destInfo[2]) - 1;
        queue.add(new Point(startY, startX, startDirection, 0));
        boolean[][][] isVisited = new boolean[map.length][map[0].length][4];
        isVisited[startY][startX][startDirection] = true;
        while (queue.size() != 0) {
            Point point = queue.poll();
            int y = point.y;
            int x = point.x;
            int direction = point.direction;
            int count = point.count;
            if (x == destX && y == destY && direction == destDirection) {
                return count;
            }
            for (int j = 0; j < 2; j++) {
                if (!isVisited[y][x][DIRECTION_ARROW[direction][j]]) {
                    isVisited[y][x][DIRECTION_ARROW[direction][j]] = true;
                    queue.add(new Point(y, x, DIRECTION_ARROW[direction][j], count + 1));
                }
            }
            for (int j = 1; j <= 3; j++) {
                int nextY = y + Y_ARROW[direction] * j;
                int nextX = x + X_ARROW[direction] * j;
                if (!(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0)) {
                    if (map[nextY][nextX] != 0) {
                        break;
                    }
                    if (!isVisited[nextY][nextX][direction]) {
                        isVisited[nextY][nextX][direction] = true;
                        queue.add(new Point(nextY, nextX, direction, count + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Point {
        int y;
        int x;
        int direction;
        int count;

        public Point(int y, int x, int direction, int count) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.count = count;
        }
    }
}
