package bj2210;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        int[][] map = new int[5][5];
        Set<String> dupCheck = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 1, map[i][j] + " ", map, dupCheck);
            }
        }
        bw.write(dupCheck.size() + "");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int count, String log, int[][] map, Set<String> dupCheck) {
        if (count == 6) {
            dupCheck.add(log);
        } else {
            for (int i = 0; i < 4; i++) {
                int nextY = y + yArrow[i];
                int nextX = x + xArrow[i];
                if (nextY >= 0 && nextY < 5 && nextX >= 0 && nextX < 5) {
                    dfs(nextY, nextX, count + 1, log + map[nextY][nextX] + " ", map, dupCheck);
                }
            }
        }
    }
}
