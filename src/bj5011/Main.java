package bj5011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static char[][] graph;
    static int size;
    static int[] xArrow, yArrow;
    static boolean[][] bfsIsVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        graph = new char[size][size];
        long[][] robotRoute = new long[size + 1][size + 1];
        bfsIsVisited = new boolean[size][size];
        robotRoute[0][0] = 1;
        for (int i = 0; i < size; i++) {
            String input = br.readLine();
            for (int j = 0; j < size; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph[i][j] == '.') {
                    robotRoute[i][j + 1] += robotRoute[i][j] % Integer.MAX_VALUE;
                    robotRoute[i + 1][j] += robotRoute[i][j] % Integer.MAX_VALUE;
                } else if (i != 0 && j != 0) {
                    robotRoute[i][j] = 0;
                }
            }
        }
        if (robotRoute[size - 1][size - 1] == 0) {
            xArrow = new int[]{-1, 1, 0, 0};
            yArrow = new int[]{0, 0, -1, 1};
            if (graph[size - 1][size - 1] == '#') {
                System.out.println("INCONCEIVABLE");
            } else {
                bfs(0, 0);
                if (!bfsIsVisited[size - 1][size - 1]) {
                    System.out.println("INCONCEIVABLE");
                } else {
                    System.out.println("THE GAME IS A LIE");
                }
            }
        } else {
            System.out.println(robotRoute[size - 1][size - 1] % Integer.MAX_VALUE);
        }
    }

    public static void bfs(int y, int x) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        bfsIsVisited[y][x] = true;
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            if(x==size-1&&y==size-1)
                break;
            for (int i = 0; i < 4; i++) {
                if (!(next.y + yArrow[i] >= size) && !(x + xArrow[i] >= size) && !(y + yArrow[i] < 0) && !(x + xArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == '.' && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]]) {
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