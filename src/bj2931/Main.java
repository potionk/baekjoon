package bj2931;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {1, 0, -1, 0}, Y_ARROW = {0, 1, 0, -1}; // 동남서북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] RC = br.readLine().split(" ");
        int ySize = Integer.parseInt(RC[0]);
        int xSize = Integer.parseInt(RC[1]);
        char[][] map = new char[ySize][xSize];
        Point start = new Point(0, 0), end = null;
        for (int i = 0; i < ySize; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < xSize; j++) {
                map[i][j] = readLine.charAt(j);
                if (map[i][j] == 'M') {
                    start = new Point(i, j);
                } else if (map[i][j] == 'Z') {
                    end = new Point(i, j);
                }
            }
        }
        Point next = findFirstPoint(start, map, ySize, xSize);
        boolean[][] visited = new boolean[ySize][xSize];
        Point blank = movePoint(next, map, ySize, xSize, visited);
        char[] block = {'|', '-', '+', '1', '2', '3', '4'};
        for (char c : block) {
            map[blank.y][blank.x] = c;
            boolean[][] visitedCopy = arrayCopy(visited, ySize, xSize);
            Point result = movePoint(blank, map, ySize, xSize, visitedCopy);
            if (result.y == end.y && result.x == end.x) {
                bw.write((blank.y + 1) + " " + (blank.x + 1) + " " + c);
                break;
            } else {
                map[blank.y][blank.x] = '.';
            }
        }
        br.close();
        bw.close();
    }

    public static Point movePoint(Point next, char[][] map, int ySize, int xSize, boolean[][] visited) {
        int nextY = next.y;
        int nextX = next.x;
        int before = next.before;
        while (isValidatedPoint(nextY, nextX, ySize, xSize) && (map[nextY][nextX] != '.' && map[nextY][nextX] != 'Z') && (map[nextY][nextX] == '+' || !visited[nextY][nextX])) {
            visited[nextY][nextX] = true;
            switch (map[nextY][nextX]) {
                case '|' -> {
                    if (before == 3) {
                        nextY++;
                    } else if (before == 1) {
                        nextY--;
                    }
                }
                case '-' -> {
                    if (before == 2) {
                        nextX++;
                    } else if (before == 0) {
                        nextX--;
                    }
                }
                case '+' -> {
                    if (before == 3) {
                        nextY++;
                    } else if (before == 1) {
                        nextY--;
                    } else if (before == 2) {
                        nextX++;
                    } else {
                        nextX--;
                    }
                }
                case '1' -> {
                    if (before == 0) {
                        nextY++;
                        before = 3;
                    } else if (before == 1) {
                        nextX++;
                        before = 2;
                    }
                }
                case '2' -> {
                    if (before == 0) {
                        nextY--;
                        before = 1;
                    } else if (before == 3) {
                        nextX++;
                        before = 2;
                    }
                }
                case '3' -> {
                    if (before == 2) {
                        nextY--;
                        before = 1;
                    } else if (before == 3) {
                        nextX--;
                        before = 0;
                    }
                }
                case '4' -> {
                    if (before == 2) {
                        nextY++;
                        before = 3;
                    } else if (before == 1) {
                        nextX--;
                        before = 0;
                    }
                }
            }
        }
        return new Point(nextY, nextX, before);
    }

    public static Point findFirstPoint(Point start, char[][] map, int ySize, int xSize) {
        int y = start.y;
        int x = start.x;
        int nextY, nextX;
        for (int i = 0; i < 4; i++) {
            nextY = y + Y_ARROW[i];
            nextX = x + X_ARROW[i];
            if (isValidatedPoint(nextY, nextX, ySize, xSize) && map[nextY][nextX] != '.') {
                return new Point(nextY, nextX, (i + 2) % 4);
            }
        }
        return new Point(-1, -1);
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
    }

    public static boolean[][] arrayCopy(boolean[][] src, int ySize, int xSize) {
        boolean[][] newArray = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                newArray[i][j] = src[i][j];
            }
        }
        return newArray;
    }

    private static class Point {
        int y;
        int x;
        int before;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Point(int y, int x, int before) {
            this.y = y;
            this.x = x;
            this.before = before;
        }
    }
}
