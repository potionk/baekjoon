package bj16948;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static final int[] X_ARROW = {-2, -2, +0, +0, +2, +2};
    static final int[] Y_ARROW = {-1, +1, -2, +2, -1, +1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] r1c1r2c2 = br.readLine().split(" ");
        bw.write(bfs(new Point(Integer.parseInt(r1c1r2c2[1]), Integer.parseInt(r1c1r2c2[0]), 0),
                new Point(Integer.parseInt(r1c1r2c2[3]), Integer.parseInt(r1c1r2c2[2]), 0),
                new boolean[n][n], n) + "");
        br.close();
        bw.close();
    }

    public static int bfs(Point start, Point end, boolean[][] visited, int size) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;
        int y, x, count;
        while (queue.size() != 0) {
            Point next = queue.poll();
            y = next.y;
            x = next.x;
            count = next.count;
            if (end.y == y && end.x == x) {
                return next.count;
            }
            for (int i = 0; i < 6; i++) {
                int nextY = y + Y_ARROW[i];
                int nextX = x + X_ARROW[i];
                if (isValidatedPoint(nextY, nextX, size) && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.add(new Point(nextY, nextX, count + 1));
                }
            }
        }
        return -1;
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int size) {
        return !(nextY >= size) && !(nextX >= size) && !(nextY < 0) && !(nextX < 0);
    }

    private static class Point {
        int y;
        int x;
        int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
