package bj18428;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static final int[] xArrow = {1, 0, -1, 0}, yArrow = {0, -1, 0, 1};
    static int tcSize;
    static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tcSize = Integer.parseInt(br.readLine());
        isFinish = false;
        char[][] map = new char[tcSize][tcSize];
        ArrayList<Point> teacherList = new ArrayList<>();
        ArrayList<Point> xList = new ArrayList<>();
        for (int i = 0; i < tcSize; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < tcSize; j++) {
                map[i][j] = readLine[j].charAt(0);
                if (map[i][j] == 'T') {
                    teacherList.add(new Point(i, j));
                } else if (map[i][j] == 'X') {
                    xList.add(new Point(i, j));
                }
            }
        }
        int xListSize = xList.size();
        int teacherListSize = teacherList.size();
        for (int i = 0; i < xListSize - 2; i++) {
            dfs(i, 1, map, teacherList, xList, xListSize, teacherListSize);
        }
        if (isFinish) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }

    static void dfs(int idx, int count, char[][] map, ArrayList<Point> teacherList, ArrayList<Point> xList, int xListSize, int teacherSize) {
        if (!(count > 3) && idx < xListSize && !isFinish) {
            Point X = xList.get(idx);
            map[X.y][X.x] = 'O';
            boolean isFindStudent = false;
            for (int i = 0; i < teacherSize; i++) {
                Point teacherPoint = teacherList.get(i);
                if (isFindStudent) {
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    if (isFindStudent) {
                        break;
                    }
                    int nextY = teacherPoint.y + yArrow[j];
                    int nextX = teacherPoint.x + xArrow[j];
                    while (nextY >= 0 && nextY < tcSize && nextX >= 0 && nextX < tcSize) {
                        if (map[nextY][nextX] == 'S') {
                            isFindStudent = true;
                            break;
                        } else if (map[nextY][nextX] == 'O') {
                            break;
                        }
                        nextY += yArrow[j];
                        nextX += xArrow[j];
                    }
                }
            }
            if (isFindStudent) {
                for (int i = idx; i < xListSize - 1; i++) {
                    dfs(i + 1, count + 1, map, teacherList, xList, xListSize, teacherSize);
                }
            } else {
                isFinish = true;
            }
            map[X.y][X.x] = 'X';
        }
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}