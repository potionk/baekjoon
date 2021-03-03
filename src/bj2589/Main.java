package bj2589;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};
    static int maxCount, maxX, maxY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        int ySize = Integer.parseInt(size[0]);
        int xSize = Integer.parseInt(size[1]);
        boolean[][] map = new boolean[ySize][xSize]; // sea->false, land->true
        for (int i = 0; i < ySize; i++) {
            String readline = br.readLine();
            for (int j = 0; j < xSize; j++) {
                if (readline.charAt(j) == 'L') {
                    map[i][j] = true;
                }
            }
        }
        boolean[][] isVisited = new boolean[ySize][xSize];
        int result = 0;
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (map[i][j]) {
                    maxCount = 0;
                    bfs(i, j, isVisited, map, ySize, xSize);
                    maxCount = 0;
                    boolean[][] isVisitedMax = new boolean[ySize][xSize];
                    bfs(maxY, maxX, isVisitedMax, map, ySize, xSize);
                    result = Math.max(result, maxCount);
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void bfs(int y, int x, boolean[][] isVisited, boolean[][] map, int ySize, int xSize) {
        LinkedList<Point> queue = new LinkedList<>();
        int count = 0;
        queue.add(new Point(y, x, count));
        isVisited[y][x] = true;
        while (queue.size() != 0) {
            Point next = queue.poll();
            y = next.getY();
            x = next.getX();
            count = next.getCount();
            maxCount = Math.max(count, maxCount);
            if (maxCount == count) {
                maxX = x;
                maxY = y;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = y + Y_ARROW[i];
                int nextX = x + X_ARROW[i];
                if (!(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0) && map[nextY][nextX] && !isVisited[nextY][nextX]) {
                    queue.add(new Point(nextY, nextX, count + 1));
                    isVisited[nextY][nextX] = true;
                }
            }
        }
    }
}

class Point {
    private final int x;
    private final int y;
    private final int count;

    public Point(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }
}