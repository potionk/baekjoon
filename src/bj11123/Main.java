package bj11123;

import java.io.*;

public class Main {
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] info = br.readLine().split(" ");
            int ySize = Integer.parseInt(info[0]);
            int xSize = Integer.parseInt(info[1]);
            char[][] map = new char[ySize][xSize];
            boolean[][] isVisited = new boolean[ySize][xSize];
            for (int i = 0; i < ySize; i++) {
                String readline = br.readLine();
                for (int j = 0; j < xSize; j++) {
                    map[i][j] = readline.charAt(j);
                }
            }
            int result = 0;
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    if (map[i][j] == '#' && !isVisited[i][j]) {
                        result++;
                        dfs(i, j, map, isVisited, ySize, xSize);
                    }
                }
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, char[][] map, boolean[][] isVisited, int ySize, int xSize) {
        isVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = y + yArrow[i];
            int nextX = x + xArrow[i];
            if (nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && !isVisited[nextY][nextX] && map[nextY][nextX] == '#') {
                dfs(nextY, nextX, map, isVisited, ySize, xSize);
            }
        }
    }
}