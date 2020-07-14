package bj10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] normal, blind;
    static boolean[][] dfsIsVisited;
    static int size;
    static int[] ddX, ddY;
    static List<Integer> normalResult, blindResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        normal = new int[size][size];
        blind = new int[size][size];
        dfsIsVisited = new boolean[size][size];
        ddX = new int[]{1, 0, -1, 0};
        ddY = new int[]{0, -1, 0, 1};
        normalResult = new ArrayList<>();
        blindResult = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            for (int j = 0; j < size; j++) {
                int data = input.charAt(j);
                normal[i][j] = data;
                if (data == 71)
                    blind[i][j] = 82;
                else
                    blind[i][j] = data;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!dfsIsVisited[i][j]) {
                    dfs(i, j, normal[i][j], false);
                    normalResult.add(1);
                }
            }
        }
        dfsIsVisited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!dfsIsVisited[i][j]) {
                    dfs(i, j, blind[i][j], true);
                    blindResult.add(1);
                }
            }
        }
        System.out.println(normalResult.size() + " " + blindResult.size());
    }

    public static void dfs(int y, int x, int color, boolean isBlind) {
        dfsIsVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if (!(x + ddX[i] < 0) && !(y + ddY[i] < 0) && !(x + ddX[i] >= size) && !(y + ddY[i] >= size) && !dfsIsVisited[y + ddY[i]][x + ddX[i]])
                if ((isBlind && blind[y + ddY[i]][x + ddX[i]] == color) || !isBlind && normal[y + ddY[i]][x + ddX[i]] == color)
                    dfs(y + ddY[i], x + ddX[i], color, isBlind);
        }
    }
}