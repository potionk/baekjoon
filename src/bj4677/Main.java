package bj4677;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static char[][] graph;
    static boolean[][] dfsIsVisited;
    static int ySize, xSize;
    static List<Integer> result;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] size = br.readLine().split(" ");
            ySize = Integer.parseInt(size[0]);
            xSize = Integer.parseInt(size[1]);
            if (ySize == 0 && xSize == 0)
                break;
            graph = new char[ySize][xSize];
            dfsIsVisited = new boolean[ySize][xSize];
            result = new ArrayList<>();
            xArrow = new int[]{0, 1, 1, 1, 0, -1, - 1, -1};
            yArrow = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
            for (int i = 0; i < ySize; i++) {
                String input = br.readLine();
                for (int j = 0; j < xSize; j++) {
                    graph[i][j] = input.charAt(j);
                }
            }
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    if (graph[i][j] == '@' && !dfsIsVisited[i][j]) {
                        dfs(i, j);
                        result.add(1);
                    }
                }
            }
            System.out.println(result.size());
        }
    }

    public static void dfs(int y, int x) {
        dfsIsVisited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            if (!(x + xArrow[i] >= xSize) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= ySize) && !(y + yArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == '@' && !dfsIsVisited[y + yArrow[i]][x + xArrow[i]])
                dfs(y + yArrow[i], x + xArrow[i]);
        }
    }
}