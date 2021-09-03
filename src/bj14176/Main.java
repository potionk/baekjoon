package bj14176;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1, 1, 1, -1, -1}, Y_ARROW = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);
        int[][] map = new int[M][N];
        boolean[][] isVisited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    dfs(i, j, map, isVisited);
                    result++;
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int[][] map, boolean[][] isVisited) {
        for (int i = 0; i < 8; i++) {
            int nextY = y + Y_ARROW[i];
            int nextX = x + X_ARROW[i];
            if (isValidatedPoint(nextY, nextX, map.length, map[0].length) && map[nextY][nextX] == 1 && !isVisited[nextY][nextX]) {
                isVisited[nextY][nextX] = true;
                dfs(nextY, nextX, map, isVisited);
            }
        }
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
    }
}
