package bj7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][] bfsIsVisited;
    static int size;
    static XY finishXY;
    static int[][] count;
    static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            size = Integer.parseInt(br.readLine());
            graph = new int[size][size];
            count = new int[size][size];
            isFinish = false;
            String[] startStr = br.readLine().split(" ");
            String[] finishStr = br.readLine().split(" ");
            finishXY = new XY(Integer.parseInt(finishStr[0]), Integer.parseInt(finishStr[1]));
            bfsIsVisited = new boolean[size][size];
            bfs(Integer.parseInt(startStr[1]), Integer.parseInt(startStr[0]));
        }

    }

    public static void bfs(int y, int x) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        bfsIsVisited[y][x] = true;
        count[y][x] = 0;
        int[] nextX = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] nextY = {-2, 2, -2, 2, -1, 1, -1, 1};
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            if (x == finishXY.getX() && y == finishXY.getY()) {
                System.out.println(count[y][x]);
                break;
            }

            for (int i = 0; i < 8; i++) {
                if (!(y + nextY[i] < 0) && !(x + nextX[i] < 0) && !(y + nextY[i] >= size) && !(x + nextX[i] >= size) && !bfsIsVisited[y + nextY[i]][x + nextX[i]]) {
                    queue.add(new XY(x + nextX[i], y + nextY[i]));
                    bfsIsVisited[y + nextY[i]][x + nextX[i]] = true;
                    count[y + nextY[i]][x + nextX[i]] = count[y][x] + 1;
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