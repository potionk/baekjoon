package bj1743;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int[] xArrow, yArrow;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        int result = 0;
        String[] info = br.readLine().split(" ");
        int ySize = Integer.parseInt(info[0]);
        int xSize = Integer.parseInt(info[1]);
        int K = Integer.parseInt(info[2]);
        boolean[][] map = new boolean[ySize][xSize];
        boolean[][] isVisited = new boolean[ySize][xSize];
        List<XY> trashList = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            String[] trashLoc = br.readLine().split(" ");
            int y = Integer.parseInt(trashLoc[0]) - 1;
            int x = Integer.parseInt(trashLoc[1]) - 1;
            map[y][x] = true;
            trashList.add(new XY(y, x));
        }
        for (XY xy : trashList) {
            count = 0;
            dfs(xy.getY(), xy.getX(), map, isVisited, ySize, xSize);
            result = Math.max(count, result);
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, boolean[][] map, boolean[][] isVisited, int ySize, int xSize) {
        count++;
        isVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextY = y + yArrow[i];
            int nextX = x + xArrow[i];
            if (nextY >= 0 && nextY < ySize && nextX >= 0 && nextX < xSize && !isVisited[nextY][nextX] && map[nextY][nextX]) {
                dfs(nextY, nextX, map, isVisited, ySize, xSize);
            }
        }
    }
}

class XY {
    int y;
    int x;

    public XY(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}