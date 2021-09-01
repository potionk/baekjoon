package bj2665;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static final int[] xArrow = {0, 1, 0, -1}, yArrow = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }
        int[][] count = new int[n][n];
        bw.write(bfs(0, 0, graph, count, n) + "");
        bw.close();
    }

    public static int bfs(int y, int x, int[][] graph, int[][] count, int size) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count[i][j] = -1;
            }
        }
        if (graph[y][x] == 0) {
            count[y][x] = 1;
        } else {
            count[y][x] = 0;
        }
        while (queue.size() != 0) {
            Point p = queue.poll();
            x = p.getX();
            y = p.getY();
            for (int i = 0; i < 4; i++) {
                int nextY = y + yArrow[i];
                int nextX = x + xArrow[i];
                if (isValidatedPoint(nextY, nextX, size)) {
                    if (graph[nextY][nextX] == 0 && (count[nextY][nextX] == -1 || count[nextY][nextX] > count[y][x] + 1)) {
                        queue.add(new Point(nextX, nextY));
                        count[nextY][nextX] = count[y][x] + 1;
                    }
                    if (graph[nextY][nextX] == 1 && (count[nextY][nextX] == -1 || count[nextY][nextX] > count[y][x])) {
                        queue.add(new Point(nextX, nextY));
                        count[nextY][nextX] = count[y][x];
                    }
                }
            }
        }
        if (count[size - 1][size - 1] == -1) {
            return 0;
        } else {
            return count[size - 1][size - 1];
        }
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int n) {
        return !(nextY >= n) && !(nextX >= n) && !(nextY < 0) && !(nextX < 0);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}