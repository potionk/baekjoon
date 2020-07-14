package bj6601;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static boolean[][] bfsIsVisited;
    static int size;
    static int[][] count;
    static int[] xArrow, yArrow;
    static XY finish;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = 8;
        xArrow = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        yArrow = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            XY start = new XY(input[0].charAt(0) - 97, input[0].charAt(1) - 49);
            finish = new XY(input[1].charAt(0) - 97, input[1].charAt(1) - 49);
            bfsIsVisited = new boolean[size][size];
            count = new int[size][size];
            bfs(start.getY(), start.getX());
            System.out.println("To get from " + input[0] + " to " + input[1] + " takes " + count[finish.getY()][finish.getX()] + " knight moves.");
        }
    }

    public static void bfs(int y, int x) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        bfsIsVisited[y][x] = true;
        count[y][x] = 0;
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            if (x == finish.getX() && y == finish.getY())
                break;
            for (int i = 0; i < 8; i++) {
                if (!(next.y + yArrow[i] >= size) && !(x + xArrow[i] >= size) && !(y + yArrow[i] < 0) && !(x + xArrow[i] < 0) && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]]) {
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