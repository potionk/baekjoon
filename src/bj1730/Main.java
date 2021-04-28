package bj1730;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] horizontal = new boolean[n][n];
        boolean[][] vertical = new boolean[n][n];
        String cmd = br.readLine();
        int cmdLen = cmd.length();
        int y = 0, x = 0;
        for (int i = 0; i < cmdLen; i++) {
            char c = cmd.charAt(i);
            Point next = getNext(c);
            int nextY = y + next.y;
            int nextX = x + next.x;
            if (0 <= nextY && nextY < n && 0 <= nextX && nextX < n) {
                if (isVertical(c)) {
                    vertical[y][x] = true;
                    vertical[nextY][nextX] = true;
                } else {
                    horizontal[y][x] = true;
                    horizontal[nextY][nextX] = true;
                }
                y = nextY;
                x = nextX;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (vertical[i][j]) {
                    if (horizontal[i][j]) {
                        bw.write("+");
                    } else {
                        bw.write("|");
                    }
                } else if (horizontal[i][j]) {
                    bw.write("-");
                } else {
                    bw.write(".");
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    private static Point getNext(char c) {
        return switch (c) {
            case 'D' -> new Point(0, 1);
            case 'R' -> new Point(1, 0);
            case 'U' -> new Point(0, -1);
            case 'L' -> new Point(-1, 0);
            default -> null;
        };
    }

    private static boolean isVertical(char c) {
        return switch (c) {
            case 'D', 'U' -> true;
            default -> false;
        };
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
