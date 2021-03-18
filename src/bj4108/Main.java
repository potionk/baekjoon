package bj4108;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1, 1, 1, -1, -1}, Y_ARROW = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0")) {
            String[] size = input.split(" ");
            int R = Integer.parseInt(size[0]);
            int C = Integer.parseInt(size[1]);
            List<Point> bombList = new LinkedList<>();
            char[][] map = new char[R][C];
            int[][] bombMap = new int[R][C];
            for (int i = 0; i < R; i++) {
                String readLine = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = readLine.charAt(j);
                    if (map[i][j] == '*') {
                        bombList.add(new Point(j, i));
                    }
                }
            }
            for (Point p : bombList) {
                int pX = (int) p.getX();
                int pY = (int) p.getY();
                for (int k = 0; k < 8; k++) {
                    int nextX = pX + X_ARROW[k];
                    int nextY = pY + Y_ARROW[k];
                    if (nextX < C && nextY < R && nextX >= 0 && nextY >= 0) {
                        bombMap[nextY][nextX]++;
                    }
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == '*') {
                        bw.write("*");
                    } else {
                        bw.write(bombMap[i][j] + "");
                    }
                }
                bw.write("\n");
            }
        }
        br.close();
        bw.close();
    }
}
