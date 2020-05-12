package bj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] graph;
    static boolean[][] dfsIsVisited;
    static int size;
    static List<Integer> result;
    static int currentCount;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        dfsIsVisited = new boolean[size][size];
        result = new ArrayList<>();
        currentCount = 0;
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] == 1 && !dfsIsVisited[i][j]) {
                    dfs(i, j);
                    result.add(currentCount);
                    currentCount = 0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void dfs(int y, int x) {
        dfsIsVisited[y][x] = true;
        currentCount++;
        for (int i = 0; i < 4; i++) {
            if (!(x + xArrow[i] >= size) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= size) && !(y + yArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == 1 && !dfsIsVisited[y + yArrow[i]][x + xArrow[i]])
                dfs(y + yArrow[i], x + xArrow[i]);
        }
    }
}