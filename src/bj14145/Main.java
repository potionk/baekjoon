package bj14145;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int[] xArrow, yArrow;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        String[] info = br.readLine().split(" ");
        int ySize = Integer.parseInt(info[0]);
        int xSize = Integer.parseInt(info[1]);
        char[][] map = new char[ySize][xSize];
        boolean[][] isVisited = new boolean[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String readline = br.readLine();
            for (int j = 0; j < xSize; j++) {
                map[i][j] = readline.charAt(j);
            }
        }
        List<Farm> farmList = new LinkedList<>();
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                if (map[i][j] == '1' && !isVisited[i][j]) {
                    size = 0;
                    dfs(i, j, map, isVisited, ySize, xSize, false, '0');
                    farmList.add(new Farm(i, j, size));
                }
            }
        }
        char idx = '1';
        Collections.sort(farmList);
        isVisited = new boolean[ySize][xSize];
        for (Farm f : farmList) {
            dfs(f.getY(), f.getX(), map, isVisited, ySize, xSize, true, idx);
            idx++;
        }
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, char[][] map, boolean[][] isVisited, int ySize, int xSize, boolean paintMode, char color) {
        isVisited[y][x] = true;
        if (paintMode) {
            map[y][x] = color;
        } else {
            size++;
        }
        for (int i = 0; i < 4; i++) {
            int nextY = y + yArrow[i];
            int nextX = x + xArrow[i];
            if (nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && !isVisited[nextY][nextX] && map[nextY][nextX] == '1') {
                dfs(nextY, nextX, map, isVisited, ySize, xSize, paintMode, color);
            }
        }
    }
}

class Farm implements Comparable<Farm> {
    int y;
    int x;
    int area;

    public Farm(int y, int x, int area) {
        this.y = y;
        this.x = x;
        this.area = area;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getArea() {
        return area;
    }

    @Override
    public int compareTo(Farm o) {
        return Integer.compare(this.area, o.area);
    }
}