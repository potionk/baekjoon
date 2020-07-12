package bj1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][][] bfsIsVisited;
    static int xSize, ySize, K;
    static int[][] count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        String[] size = br.readLine().split(" ");
        ySize = Integer.parseInt(size[1]);
        xSize = Integer.parseInt(size[0]);
        graph = new int[ySize][xSize];
        count = new int[ySize][xSize];
        xArrow = new int[]{1, 0, -1, 0, 1, 2, 2, 1, -1, -2, -2, -1};
        yArrow = new int[]{0, -1, 0, 1, -2, -1, 1, 2, 2, 1, -1, -2};
        for (int i = 0; i < ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                graph[i][j] = Integer.parseInt(input[j] + "");
            }
        }
        bfsIsVisited = new boolean[ySize][xSize][K + 1];

        System.out.println(bfs(0, 0));
    }

    public static int bfs(int y, int x) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y, 0, 0));
        bfsIsVisited[y][x][0] = true;
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            int count = next.getCount();
            if (x == xSize - 1 && y == ySize - 1)
                return count;
            int horseCount = next.getHorseCount();
            int max = horseCount < K ? 12 : 4;
            for (int i = 0; i < max; i++) {
                if (!(next.y + yArrow[i] >= ySize) && !(x + xArrow[i] >= xSize) && !(y + yArrow[i] < 0) && !(x + xArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == 0 && (i / 4 == 0 || (i / 4 != 0 && (horseCount + 1) <= K)) && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]][i / 4 != 0 ? horseCount + 1 : horseCount]) {
                    queue.add(new XY(x + xArrow[i], y + yArrow[i], count + 1, i / 4 != 0 ? horseCount + 1 : horseCount));
                    bfsIsVisited[y + yArrow[i]][x + xArrow[i]][i / 4 != 0 ? horseCount + 1 : horseCount] = true;
                }
            }
        }
        return -1;
    }
}

class XY {
    int x;
    int y;
    int count;
    int horseCount;

    public XY(int x, int y, int count, int horseCount) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.horseCount = horseCount;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }

    public int getHorseCount() {
        return horseCount;
    }
}