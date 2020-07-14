package bj5048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static char[][] graph;
    static int xSize, ySize, count;
    static int[] xArrow, yArrow;
    static boolean[][] bfsIsVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        xSize = Integer.parseInt(size[0]);
        ySize = Integer.parseInt(size[1]);
        graph = new char[ySize][xSize];
        bfsIsVisited = new boolean[ySize][xSize];
        xArrow = new int[]{-1, 1, 0, 0};
        yArrow = new int[]{0, 0, -1, 1};
        count = 0;
        XY start = null;
        for (int i = 0; i < ySize; i++) {
            String input = br.readLine();
            for (int j = 0; j < xSize; j++) {
                graph[i][j] = input.charAt(j);
                if (graph[i][j] == 'P')
                    start = new XY(j, i);
            }
        }
        assert start != null;
        bfs(start.getY(), start.getX());
        System.out.println(count);
    }

    public static void bfs(int y, int x) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        bfsIsVisited[y][x] = true;
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            if (graph[y][x] == 'G')
                count++;
            if (graph[y][x + 1] == 'T' || graph[y + 1][x] == 'T' || graph[y][x - 1] == 'T' || graph[y - 1][x] == 'T')
                continue;
            for (int i = 0; i < 4; i++) {
                if (!(next.y + yArrow[i] >= ySize) && !(x + xArrow[i] >= xSize) && !(y + yArrow[i] < 0) && !(x + xArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] != '#' && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]]) {
                    queue.add(new XY(x + xArrow[i], y + yArrow[i]));
                    bfsIsVisited[y + yArrow[i]][x + xArrow[i]] = true;
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