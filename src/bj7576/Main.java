package bj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static int count;
    static int xSize, ySize;
    static int totalNonMinusOne;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        xSize = Integer.parseInt(testCase[0]);
        ySize = Integer.parseInt(testCase[1]);
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        ArrayList<XY> list = new ArrayList<>();
        count = 0;
        int nonMinusOne = 0;
        totalNonMinusOne = 0;
        graph = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if (graph[i][j] == 1) {
                    list.add(new XY(j, i));
                    totalNonMinusOne++;
                }
                if (graph[i][j] != -1)
                    nonMinusOne++;
            }
        }
        bfs(list);
        if (totalNonMinusOne != nonMinusOne)
            System.out.println(-1);
        else
            System.out.println(count);
    }

    public static void bfs(ArrayList<XY> list) {
        LinkedList<XY> queue = new LinkedList<>(list);
        boolean isContinue = true;
        while (isContinue) {
            isContinue = false;
            int beforeQueueSize = queue.size();
            for (int i = 0; i < beforeQueueSize; i++) {
                XY next = queue.poll();
                int x = next.getX();
                int y = next.getY();
                for (int a = 0; a < 4; a++) {
                    if (!(x + xArrow[a] < 0) && !(y + yArrow[a] < 0) && !(x + xArrow[a] >= xSize) && !(y + yArrow[a] >= ySize) && graph[y + yArrow[a]][x + xArrow[a]] == 0) {
                        queue.add(new XY(x + xArrow[a], y + yArrow[a]));
                        graph[y + yArrow[a]][x + xArrow[a]] = 1;
                        isContinue = true;
                        totalNonMinusOne++;
                    }
                }
            }
            if (isContinue)
                count++;
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