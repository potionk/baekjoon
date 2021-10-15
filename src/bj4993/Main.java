package bj4993;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String WH;
        while (!(WH = br.readLine()).equals("0 0")) {
            String[] split = WH.split(" ");
            int xSize = Integer.parseInt(split[0]);
            int ySize = Integer.parseInt(split[1]);
            char[][] map = new char[ySize][xSize];
            Point startPoint = new Point(0, 0);
            for (int i = 0; i < ySize; i++) {
                String readLine = br.readLine();
                for (int j = 0; j < xSize; j++) {
                    map[i][j] = readLine.charAt(j);
                    if (map[i][j] == '@') {
                        startPoint.y = i;
                        startPoint.x = j;
                    }
                }
            }
            count = 0;
            dfs(startPoint.y, startPoint.x, map, new boolean[ySize][xSize], ySize, xSize);
            bw.write(count + "\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, char[][] map, boolean[][] visited, int ySize, int xSize) {
        count++;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = y + Y_ARROW[i];
            int nextX = x + X_ARROW[i];
            if (isValidatedPoint(nextY, nextX, ySize, xSize) && !visited[nextY][nextX] && map[nextY][nextX] == '.') {
                dfs(nextY, nextX, map, visited, ySize, xSize);
            }
        }
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
    }

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
