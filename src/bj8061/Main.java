package bj8061;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static int xSize, ySize;
    static int[][] count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        xSize = Integer.parseInt(size[1]);
        ySize = Integer.parseInt(size[0]);
        graph = new int[ySize][xSize];
        count = new int[ySize][xSize];
        xArrow = new int[]{1, 0, -1, 0};
        yArrow = new int[]{0, -1, 0, 1};
        LinkedList<XY> queue = new LinkedList<>();

        for (int i = 0; i < ySize; i++) {
            String input = br.readLine();
            for (int j = 0; j < xSize; j++) {
                char ca = input.charAt(j);
                if (ca == '1')
                    queue.add(new XY(j, i));
                else
                    count[i][j] = 999;
                graph[i][j] = Integer.parseInt(ca + "");
            }
        }

        while (queue.size() != 0) {
            XY next = queue.poll();
            int x = next.getX();
            int y = next.getY();
            for (int i = 0; i < 4; i++) {
                if (!(next.y + yArrow[i] >= ySize) && !(x + xArrow[i] >= xSize) && !(y + yArrow[i] < 0) && !(x + xArrow[i] < 0) && graph[y + yArrow[i]][x + xArrow[i]] == 0 && count[y + yArrow[i]][x + xArrow[i]] > count[y][x] + 1) {
                    queue.add(new XY(x + xArrow[i], y + yArrow[i]));
                    count[y + yArrow[i]][x + xArrow[i]] = count[y][x] + 1;
                }
            }
        }

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++)
                System.out.print(count[i][j] + " ");
            System.out.println();
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