package bj6593;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static final int[] Z_ARROW = {0, 0, 0, 0, 1, -1};
    static final int[] X_ARROW = {0, 1, 0, -1, 0, 0};
    static final int[] Y_ARROW = {1, 0, -1, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc;
        while (!(tc = br.readLine()).equals("0 0 0")) {
            String[] LRC = tc.split(" ");
            int zSize = Integer.parseInt(LRC[0]);
            int ySize = Integer.parseInt(LRC[1]);
            int xSize = Integer.parseInt(LRC[2]);
            char[][][] map = new char[zSize][ySize][xSize];
            Point start = new Point(0, 0, 0, 0);
            for (int i = 0; i < zSize; i++) {
                for (int j = 0; j < ySize; j++) {
                    String readLine = br.readLine();
                    for (int k = 0; k < xSize; k++) {
                        map[i][j][k] = readLine.charAt(k);
                        if (map[i][j][k] == 'S') {
                            start.z = i;
                            start.y = j;
                            start.x = k;
                        }
                    }
                }
                br.readLine();
            }
            int result = bfs(start, new boolean[zSize][ySize][xSize], map, zSize, ySize, xSize);
            if (result == -1) {
                bw.write("Trapped!\n");
            } else {
                bw.write("Escaped in " + result + " minute(s).\n");
            }
        }
        br.close();
        bw.close();
    }

    public static int bfs(Point start, boolean[][][] visited, char[][][] map, int zSize, int ySize, int xSize) {
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.z][start.y][start.x] = true;
        int z, y, x, count;
        while (queue.size() != 0) {
            Point next = queue.poll();
            z = next.z;
            y = next.y;
            x = next.x;
            count = next.count;
            for (int i = 0; i < 6; i++) {
                int nextZ = z + Z_ARROW[i];
                int nextY = y + Y_ARROW[i];
                int nextX = x + X_ARROW[i];
                if (isValidatedPoint(nextZ, nextY, nextX, zSize, ySize, xSize) && !visited[nextZ][nextY][nextX]) {
                    if (map[nextZ][nextY][nextX] == '.') {
                        queue.add(new Point(nextZ, nextY, nextX, count + 1));
                        visited[nextZ][nextY][nextX] = true;
                    } else if (map[nextZ][nextY][nextX] == 'E') {
                        return count + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValidatedPoint(int nextZ, int nextY, int nextX, int zSize, int ySize, int xSize) {
        return !(nextZ >= zSize) && !(nextY >= ySize) && !(nextX >= xSize) && !(nextZ < 0) && !(nextY < 0) && !(nextX < 0);
    }

    private static class Point {
        int z;
        int y;
        int x;
        int count;

        public Point(int z, int y, int x, int count) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
