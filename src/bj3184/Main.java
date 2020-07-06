package bj3184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static char[][] graph;
    static boolean[][] dfsIsVisited;
    static int xSize, ySize;
    static List<Integer> result;
    static int sheep, wolves;
    static int sheepCount, wolvesCount;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        xSize = Integer.parseInt(size[1]);
        ySize = Integer.parseInt(size[0]);
        graph = new char[ySize][xSize];
        dfsIsVisited = new boolean[ySize][xSize];
        result = new ArrayList<>();
        sheep = 0;
        wolves = 0;
        sheepCount = 0;
        wolvesCount = 0;
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        for (int i = 0; i < ySize; i++) {
            String input = br.readLine();
            for (int j = 0; j < xSize; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (graph[i][j] != '#' && !dfsIsVisited[i][j]) {
                    if (graph[i][j] == 'o')
                        sheepCount++;
                    else if (graph[i][j] == 'v')
                        wolvesCount++;
                    dfs(i, j);
                    if (sheepCount > wolvesCount)
                        sheep += sheepCount;
                    else
                        wolves += wolvesCount;
                    sheepCount = 0;
                    wolvesCount = 0;
                }
            }
        }
        System.out.println(sheep + " " + wolves);
    }

    public static void dfs(int y, int x) {
        dfsIsVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if (!(x + xArrow[i] >= xSize) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= ySize) && !(y + yArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] != '#' && !dfsIsVisited[y + yArrow[i]][x + xArrow[i]]) {
                if (graph[y + yArrow[i]][x + xArrow[i]] == 'o')
                    sheepCount++;
                else if (graph[y + yArrow[i]][x + xArrow[i]] == 'v')
                    wolvesCount++;
                dfs(y + yArrow[i], x + xArrow[i]);
            }
        }
    }
}