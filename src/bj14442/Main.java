package bj14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][][] bfsIsVisited;
    static int xSize, ySize, K;
    static int[][][] count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        xSize = Integer.parseInt(testCase[1]);
        ySize = Integer.parseInt(testCase[0]);
        K = Integer.parseInt(testCase[2]);
        graph = new int[ySize][xSize];
        count = new int[ySize][xSize][K + 1];
        bfsIsVisited = new boolean[ySize][xSize][K + 1];
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        for (int i = 0; i < ySize; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                graph[i][j] = Integer.parseInt(input.charAt(j) + "");
                for (int k = 0; k < K + 1; k++) {
                    count[i][j][k] = -1;
                }
            }
        }
        bfs(0, 0);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < K + 1; i++) {
            if (count[ySize - 1][xSize - 1][i] > 0) {
                min = Math.min(min, count[ySize - 1][xSize - 1][i]);
            }
        }
        if (min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    public static void bfs(int y, int x) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        bfsIsVisited[y][x][0] = true;
        count[y][x][0] = 1;
        while (queue.size() != 0) {
            Point p = queue.poll();
            x = p.getX();
            y = p.getY();
            int state = p.getState();
            for (int i = 0; i < 4; i++) {
                int nextY = y + yArrow[i];
                int nextX = x + xArrow[i];
                if (!(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0)) {
                    if (graph[nextY][nextX] == 1 && state < K && !bfsIsVisited[nextY][nextX][state + 1]) {
                        queue.add(new Point(nextX, nextY, state + 1));
                        bfsIsVisited[nextY][nextX][state + 1] = true;
                        count[nextY][nextX][state + 1] = count[y][x][state] + 1;
                    }
                    if (graph[nextY][nextX] == 0 && !bfsIsVisited[nextY][nextX][state]) {
                        queue.add(new Point(nextX, nextY, state));
                        bfsIsVisited[nextY][nextX][state] = true;
                        count[nextY][nextX][state] = count[y][x][state] + 1;
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