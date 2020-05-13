package bj3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static char[][] graph;
    static int count;
    static int xSize, ySize;
    static int[] xArrow, yArrow;
    static boolean[][] hedgehogVisited;
    static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        ySize = Integer.parseInt(testCase[0]);
        xSize = Integer.parseInt(testCase[1]);
        graph = new char[ySize][xSize];
        hedgehogVisited = new boolean[ySize][xSize];
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        isFinish = false;
        XY hedgehog = null, beaver = null;
        LinkedList<XY> water = new LinkedList<>();
        count = 0;
        for (int i = 0; i < ySize; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < xSize; j++) {
                if (input[j] == 'S')
                    hedgehog = new XY(j, i);
                else if (input[j] == '*')
                    water.add(new XY(j, i));
                else if (input[j] == 'D')
                    beaver = new XY(j, i);
                graph[i][j] = input[j];
            }
        }
        bfs(hedgehog, water, beaver);
        if (!isFinish)
            System.out.println("KAKTUS");
        else
            System.out.println(count);
    }

    public static void bfs(XY hedgehog, LinkedList<XY> water, XY beaver) {
        LinkedList<XY> waterQueue = new LinkedList<>(water);
        LinkedList<XY> hedgehogQueue = new LinkedList<>();
        hedgehogQueue.add(hedgehog);
        int beaverX = beaver.getX();
        int beaverY = beaver.getY();
        boolean isContinue = true;
        while (isContinue) {
            isContinue = false;
            int waterQueueSize = waterQueue.size();
            int hedgehogQueueSize = hedgehogQueue.size();
            for (int i = 0; i < waterQueueSize; i++) {
                XY next = waterQueue.poll();
                int x = next.getX();
                int y = next.getY();
                for (int a = 0; a < 4; a++) {
                    if (!(x + xArrow[a] < 0) && !(y + yArrow[a] < 0) && !(x + xArrow[a] >= xSize) && !(y + yArrow[a] >= ySize) && graph[y + yArrow[a]][x + xArrow[a]] == '.') {
                        waterQueue.add(new XY(x + xArrow[a], y + yArrow[a]));
                        graph[y + yArrow[a]][x + xArrow[a]] = '*';
                        isContinue = true;
                    }
                }
            }
            for (int i = 0; i < hedgehogQueueSize; i++) {
                if (isFinish)
                    break;
                XY next = hedgehogQueue.poll();
                int x = next.getX();
                int y = next.getY();
                for (int a = 0; a < 4; a++) {
                    if (!(x + xArrow[a] < 0) && !(y + yArrow[a] < 0) && !(x + xArrow[a] >= xSize) && !(y + yArrow[a] >= ySize)) {
                        if (x + xArrow[a] == beaverX && y + yArrow[a] == beaverY) {
                            isContinue = false;
                            isFinish = true;
                            count++;
                            break;
                        }
                        if (graph[y + yArrow[a]][x + xArrow[a]] == '.' && !hedgehogVisited[y + yArrow[a]][x + xArrow[a]]) {
                            hedgehogQueue.add(new XY(x + xArrow[a], y + yArrow[a]));
                            hedgehogVisited[y + yArrow[a]][x + xArrow[a]] = true;
                            isContinue = true;
                        }
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