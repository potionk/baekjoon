package bj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][] bfsIsVisited;
    static int xSize, ySize;
    static int[][] count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        xSize = Integer.parseInt(size[1]);
        ySize = Integer.parseInt(size[0]);
        graph = new int[ySize][xSize];
        count = new int[ySize][xSize];
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        for (int i = 0; i < ySize; i++) {
            String input = br.readLine();
            for (int j = 0; j < xSize; j++) {
                graph[i][j] = Integer.parseInt(input.charAt(j) + "");
            }
        }
        bfsIsVisited = new boolean[ySize][xSize];
        bfs(0, 0);
        System.out.println(count[ySize - 1][xSize - 1]);
    }

    public static void bfs(int y, int x) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        bfsIsVisited[y][x] = true;
        count[y][x] = 1;
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            for (int i = 0; i < 4; i++) {
                if (!(next.y + yArrow[i] >= ySize) && !(x + xArrow[i] >= xSize) && !(y + yArrow[i] < 0) && !(x + xArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == 1 && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]]) {
                    queue.add(new XY(x + xArrow[i], y + yArrow[i]));
                    bfsIsVisited[y + yArrow[i]][x + xArrow[i]] = true;
                    count[y + yArrow[i]][x + xArrow[i]] = count[y][x] + 1;
                }
            }
        }
    }
}

class XY {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}