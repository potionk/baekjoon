package bj17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] graph;
    static int size;
    static int count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        count = 0;
        xArrow = new int[]{1, 1, 0};
        yArrow = new int[]{0, 1, 1};
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }
        // type info
        // 0 : right, 1 : 45', 2: bottom
        dfs(0, 1, 0);
        System.out.println(count);
    }

    public static void dfs(int y, int x, int type) {
        if (y == size - 1 && x == size - 1) {
            count++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!(x + xArrow[i] >= size) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= size) && !(y + yArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == 0) {
                if ((type == 0 && i != 2) || type == 1 || (type == 2 && i != 0)) {
                    if (i == 1) {
                        if (graph[y + 1][x] == 0 && graph[y][x + 1] == 0) {
                            dfs(y + yArrow[i], x + xArrow[i], i);
                        }
                    } else {
                        dfs(y + yArrow[i], x + xArrow[i], i);
                    }
                }
            }
        }
    }
}