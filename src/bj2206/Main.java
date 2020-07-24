package bj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][][] bfsIsVisited;
    static int xSize, ySize;
    static int[][][] count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        xSize = Integer.parseInt(testCase[1]);
        ySize = Integer.parseInt(testCase[0]);
        graph = new int[ySize][xSize];
        count = new int[ySize][xSize][2];
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        for (int i = 0; i < ySize; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                graph[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }
        bfsIsVisited = new boolean[ySize][xSize][2];
        bfs(0, 0);
        if (count[ySize - 1][xSize - 1][1] == 0) {
            if (count[ySize - 1][xSize - 1][0] != 0)
                System.out.println(count[ySize - 1][xSize - 1][0]);
            else
                System.out.println(-1);
        } else
            System.out.println(count[ySize - 1][xSize - 1][1]);
    }

    public static void bfs(int y, int x) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        bfsIsVisited[y][x][0] = true;
        count[y][x][0] = 1;
        while (queue.size() != 0) {
            Point next = queue.poll();
            x = next.getX();
            y = next.getY();
            int state = next.getState();
            for (int i = 0; i < 4; i++) {
                if (!(y + yArrow[i] >= ySize) && !(x + xArrow[i] >= xSize) && !(y + yArrow[i] < 0) && !(x + xArrow[i] < 0)) {
                    if (graph[y + yArrow[i]][x + xArrow[i]] == 1 && state == 0) {
                        queue.add(new Point(x + xArrow[i], y + yArrow[i], 1));
                        bfsIsVisited[y + yArrow[i]][x + xArrow[i]][1] = true;
                        count[y + yArrow[i]][x + xArrow[i]][1] = count[y][x][0] + 1;
                    }
                    if (graph[y + yArrow[i]][x + xArrow[i]] == 0) {
                        if (state == 0 && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]][0]) {
                            queue.add(new Point(x+ xArrow[i], y + yArrow[i], 0));
                            bfsIsVisited[y + yArrow[i]][x + xArrow[i]][0] = true;
                            count[y + yArrow[i]][x + xArrow[i]][0] = count[y][x][0] + 1;
                        } else if (state == 1 && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]][1]) {
                            queue.add(new Point(x + xArrow[i], y + yArrow[i], 1));
                            bfsIsVisited[y + yArrow[i]][x + xArrow[i]][1] = true;
                            count[y + yArrow[i]][x + xArrow[i]][1] = count[y][x][1] + 1;
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