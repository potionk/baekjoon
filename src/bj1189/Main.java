package bj1189;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] RCK = br.readLine().split(" ");
        int R = Integer.parseInt(RCK[0]);
        int C = Integer.parseInt(RCK[1]);
        int K = Integer.parseInt(RCK[2]);
        result = 0;
        char[][] map = new char[R][C];
        boolean[][] isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = readLine.charAt(j);
            }
        }
        isVisited[R - 1][0] = true;
        dfs(R - 1, 0, 1, K, map, isVisited, R, C);
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int count, int K, char[][] map, boolean[][] isVisited, int ySize, int xSize) {
        if (count < K) {
            for (int i = 0; i < 4; i++) {
                int nextY = y + Y_ARROW[i];
                int nextX = x + X_ARROW[i];
                if (!(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0) && map[nextY][nextX] != 'T' && !isVisited[nextY][nextX]) {
                    isVisited[nextY][nextX] = true;
                    dfs(nextY, nextX, count + 1, K, map, isVisited, ySize, xSize);
                    isVisited[nextY][nextX] = false;
                }
            }
        } else if (y == 0 && x == xSize - 1) {
            result++;
        }
    }
}
