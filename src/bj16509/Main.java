package bj16509;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static final int[] X_ARROW = {-3, -2, +2, +3, +3, +2, -2, -3};
    static final int[] Y_ARROW = {-2, -3, -3, -2, +2, +3, +3, +2};
    static final int[][] CHECK_X_ARROW = {{-1, -2}, {+0, -1}, {+0, +1}, {+1, +2}, {+1, +2}, {+0, +1}, {+0, -1}, {-1, -2}};
    static final int[][] CHECK_Y_ARROW = {{+0, -1}, {-1, -2}, {-1, -2}, {+0, -1}, {+0, +1}, {+1, +2}, {+1, +2}, {+0, +1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sang = br.readLine().split(" ");
        int sangY = Integer.parseInt(sang[0]);
        int sangX = Integer.parseInt(sang[1]);
        String[] king = br.readLine().split(" ");
        int kingY = Integer.parseInt(king[0]);
        int kingX = Integer.parseInt(king[1]);
        bw.write(bfs(sangY, sangX, kingY, kingX) + "");
        br.close();
        bw.close();
    }

    public static int bfs(int sangY, int sangX, int kingY, int kingX) {
        LinkedList<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[10][9];
        visited[sangY][sangX] = true;
        int[][] count = new int[10][9];
        queue.add(new Point(sangY, sangX));
        while (queue.size() != 0) {
            Point p = queue.poll();
            int y = p.y;
            int x = p.x;
            if (y == kingY && x == kingX) {
                return count[y][x];
            }
            for (int i = 0; i < 8; i++) {
                int nextY = y + Y_ARROW[i];
                int nextX = x + X_ARROW[i];
                if (isValidatedPoint(nextY, nextX) && !visited[nextY][nextX]) {
                    boolean overlap = false;
                    for (int j = 0; j < 2; j++) {
                        int checkY = y + CHECK_Y_ARROW[i][j];
                        int checkX = x + CHECK_X_ARROW[i][j];
                        if (kingX == checkX && kingY == checkY) {
                            overlap = true;
                            break;
                        }
                    }
                    if (!overlap) {
                        queue.add(new Point(nextY, nextX));
                        count[nextY][nextX] = count[y][x] + 1;
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValidatedPoint(int nextY, int nextX) {
        return !(nextY >= 10) && !(nextX >= 9) && !(nextY < 0) && !(nextX < 0);
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
