package bj2234;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 남 동 북 서
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};
    static int removeOneMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int xSize = Integer.parseInt(NM[0]);
        int ySize = Integer.parseInt(NM[1]);
        int[][] map = new int[ySize][xSize];
        boolean[][] isVisited = new boolean[ySize][xSize];
        int roomCount = 0, maxRoomSize = 0;
        for (int i = 0; i < ySize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (!isVisited[i][j]) {
                    int roomSize = bfs(i, j, map, isVisited, ySize, xSize, 0);
                    maxRoomSize = Math.max(roomSize, maxRoomSize);
                    roomCount++;
                }
            }
        }
        bw.write(roomCount + "\n" + maxRoomSize + "\n" + removeOneMax + "");
        br.close();
        bw.close();
    }

    // wallBreakStete -> 0: 벽 안뚫음, 1: 벽 뚫음
    public static int bfs(int y, int x, int[][] map, boolean[][] isVisited, int ySize, int xSize, int wallBreakState) {
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> wallBreakQueue = new LinkedList<>();
        queue.add(new Point(y, x));
        isVisited[y][x] = true;
        boolean[][] wallBreakVisited = new boolean[ySize][xSize];
        int count = 0;
        int maxBreakCount = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            count++;
            boolean[] wall = getWall(map[p.y][p.x]);
            for (int i = 0; i < 4; i++) {
                int nextY = p.y + Y_ARROW[i];
                int nextX = p.x + X_ARROW[i];
                if (!(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0)) {
                    if (wall[i]) {
                        if (wallBreakState == 0) {
                            wallBreakQueue.add(new Point(nextY, nextX));
                        }
                    } else {
                        if (!isVisited[nextY][nextX]) {
                            queue.add(new Point(nextY, nextX));
                            isVisited[nextY][nextX] = true;
                        }
                    }
                }
            }
        }
        while (!wallBreakQueue.isEmpty()) {
            Point p = wallBreakQueue.poll();
            if (!isVisited[p.y][p.x] && !wallBreakVisited[p.y][p.x]) {
                int breakCount = bfs(p.y, p.x, map, wallBreakVisited, ySize, xSize, 1);
                maxBreakCount = Math.max(maxBreakCount, breakCount);
            }
        }
        removeOneMax = Math.max(count + maxBreakCount, removeOneMax);
        return count;
    }

    private static boolean[] getWall(int bit) {
        boolean[] wall = new boolean[4];
        for (int idx = 0, i = 8; idx < 4; idx++, i /= 2) {
            if (bit >= i) {
                wall[idx] = true;
                bit -= i;
            }
        }
        return wall;
    }

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}