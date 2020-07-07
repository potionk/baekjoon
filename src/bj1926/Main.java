package bj1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] graph;
    static boolean[][] dfsIsVisited;
    static int xSize, ySize;
    static List<Integer> result;
    static int currentCount;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        ySize = Integer.parseInt(size[0]);
        xSize = Integer.parseInt(size[1]);
        graph = new int[ySize][xSize];
        dfsIsVisited = new boolean[ySize][xSize];
        result = new ArrayList<>();
        currentCount = 0;
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        for (int i = 0; i < ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (graph[i][j] == 1 && !dfsIsVisited[i][j]) {
                    dfs(i, j);
                    result.add(currentCount);
                    currentCount = 0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        if (result.size() == 0)
            System.out.println(0);
        else
            System.out.println(result.get(result.size() - 1));
    }

    public static void dfs(int y, int x) {
        dfsIsVisited[y][x] = true;
        currentCount++;
        for (int i = 0; i < 4; i++) {
            if (!(x + xArrow[i] >= xSize) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= ySize) && !(y + yArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == 1 && !dfsIsVisited[y + yArrow[i]][x + xArrow[i]])
                dfs(y + yArrow[i], x + xArrow[i]);
        }
    }
}