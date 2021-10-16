package bj14923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int xSize = Integer.parseInt(size[1]);
        int ySize = Integer.parseInt(size[0]);
        String[] start = br.readLine().split(" ");
        int startY = Integer.parseInt(start[0]);
        int startX = Integer.parseInt(start[1]);
        String[] end = br.readLine().split(" ");
        int endY = Integer.parseInt(end[0]);
        int endX = Integer.parseInt(end[1]);
        int[][] graph = new int[ySize][xSize];
        int[][][] count = new int[ySize][xSize][2];
        for (int i = 0; i < ySize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                graph[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        bfs(startY - 1, startX - 1, endY - 1, endX - 1, graph, count, ySize, xSize);
        if (count[endY - 1][endX - 1][1] == 0) {
            if (count[endY - 1][endX - 1][0] != 0)
                System.out.println(count[endY - 1][endX - 1][0]);
            else
                System.out.println(-1);
        } else
            System.out.println(count[endY - 1][endX - 1][1]);
    }

    public static void bfs(int y, int x, int endY, int endX, int[][] graph, int[][][] count, int ySize, int xSize) {
        boolean[][][] visited = new boolean[ySize][xSize][2];
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        visited[y][x][0] = true;
        count[y][x][0] = 0;
        while (queue.size() != 0) {
            Point p = queue.poll();
            x = p.getX();
            y = p.getY();
            if (x == endX && y == endY) {
                break;
            }
            int state = p.getState();
            for (int i = 0; i < 4; i++) {
                int nextY = y + Y_ARROW[i];
                int nextX = x + X_ARROW[i];
                if (!(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0)) {
                    if (graph[nextY][nextX] == 1 && state == 0) {
                        queue.add(new Point(nextX, nextY, 1));
                        visited[nextY][nextX][1] = true;
                        count[nextY][nextX][1] = count[y][x][0] + 1;
                    }
                    if (graph[nextY][nextX] == 0) {
                        if (state == 0 && !visited[nextY][nextX][0]) {
                            queue.add(new Point(nextX, nextY, 0));
                            visited[nextY][nextX][0] = true;
                            count[nextY][nextX][0] = count[y][x][0] + 1;
                        } else if (state == 1 && !visited[nextY][nextX][1]) {
                            queue.add(new Point(nextX, nextY, 1));
                            visited[nextY][nextX][1] = true;
                            count[nextY][nextX][1] = count[y][x][1] + 1;
                        }
                    }
                }
            }
        }
    }
}

class Point {
    int x;
    int y;
    int state;

    public Point(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getState() {
        return state;
    }
}