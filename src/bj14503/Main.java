package bj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] graph;
    static boolean[][] dfsIsVisited;
    static int xSize, ySize;
    static int count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        ySize = Integer.parseInt(size[0]);
        xSize = Integer.parseInt(size[1]);
        graph = new int[ySize][xSize];
        String[] info = br.readLine().split(" ");
        int startY = Integer.parseInt(info[0]);
        int startX = Integer.parseInt(info[1]);
        int direction = Integer.parseInt(info[2]);
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{-1, 0, 1, 0};
        count = 1;
        for (int i = 0; i < ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfsIsVisited = new boolean[ySize][xSize];
        if (graph[startY][startX] == 0) {
            dfs(startY, startX, direction);
            System.out.println(count);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int y, int x, int direction) {
        dfsIsVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4;
            if (!(x + xArrow[direction] >= xSize) && !(x + xArrow[direction] < 0) && !(y + yArrow[direction] >= ySize) && !(y + yArrow[direction] < 0) && graph[y + yArrow[direction]][x + xArrow[direction]] == 0 && !dfsIsVisited[y + yArrow[direction]][x + xArrow[direction]]) {
                dfs(y + yArrow[direction], x + xArrow[direction], direction);
                count++;
                return;
            }
        }
        int back = (direction + 2) % 4;
        if (!(x + xArrow[back] >= xSize) && !(x + xArrow[back] < 0) && !(y + yArrow[back] >= ySize) && !(y + yArrow[back] < 0) && graph[y + yArrow[back]][x + xArrow[back]] == 0) {
            dfs(y + yArrow[back], x + xArrow[back], direction);
        }
    }
}