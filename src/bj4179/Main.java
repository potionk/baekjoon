package bj4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static char[][] graph;
    static int count;
    static int xSize, ySize;
    static int[] xArrow, yArrow;
    static boolean[][] jihunVisited;
    static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        ySize = Integer.parseInt(testCase[0]);
        xSize = Integer.parseInt(testCase[1]);
        graph = new char[ySize][xSize];
        jihunVisited = new boolean[ySize][xSize];
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        isFinish = false;
        XY jihunStart = null;
        LinkedList<XY> fireStart = new LinkedList<>();
        count = 1;
        for (int i = 0; i < ySize; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < xSize; j++) {
                if (input[j] == 'J') {
                    if (i == 0 || j == 0 || i == ySize - 1 || j == xSize - 1) {
                        System.out.println(1);
                        return;
                    }
                    jihunStart = new XY(j, i);
                } else if (input[j] == 'F')
                    fireStart.add(new XY(j, i));
                graph[i][j] = input[j];
            }
        }
        bfs(jihunStart, fireStart);
        if (!isFinish)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(count);
    }

    public static void bfs(XY jihunStart, LinkedList<XY> fireStart) {
        LinkedList<XY> fireQueue = new LinkedList<>(fireStart);
        LinkedList<XY> jihunQueue = new LinkedList<>();
        jihunQueue.add(jihunStart);
        boolean isContinue = true;
        while (isContinue) {
            isContinue = false;
            int fireQueueSize = fireQueue.size();
            int jihunQueueSize = jihunQueue.size();
            for (int i = 0; i < fireQueueSize; i++) {
                XY next = fireQueue.poll();
                int x = next.getX();
                int y = next.getY();
                for (int a = 0; a < 4; a++) {
                    if (!(x + xArrow[a] < 0) && !(y + yArrow[a] < 0) && !(x + xArrow[a] >= xSize) && !(y + yArrow[a] >= ySize) && graph[y + yArrow[a]][x + xArrow[a]] == '.') {
                        fireQueue.add(new XY(x + xArrow[a], y + yArrow[a]));
                        graph[y + yArrow[a]][x + xArrow[a]] = 'F';
                        isContinue = true;
                    }
                }
            }
            for (int i = 0; i < jihunQueueSize; i++) {
                if (isFinish)
                    break;
                XY next = jihunQueue.poll();
                int x = next.getX();
                int y = next.getY();
                for (int a = 0; a < 4; a++) {
                    if (!(x + xArrow[a] < 0) && !(y + yArrow[a] < 0) && !(x + xArrow[a] >= xSize) && !(y + yArrow[a] >= ySize)) {
                        if ((x + xArrow[a] == 0 || y + yArrow[a] == 0 || y + yArrow[a] == ySize - 1 || x + xArrow[a] == xSize - 1) && graph[y + yArrow[a]][x + xArrow[a]] == '.') {
                            isContinue = false;
                            isFinish = true;
                            count++;
                            break;
                        }
                        if (graph[y + yArrow[a]][x + xArrow[a]] == '.' && !jihunVisited[y + yArrow[a]][x + xArrow[a]]) {
                            jihunQueue.add(new XY(x + xArrow[a], y + yArrow[a]));
                            jihunVisited[y + yArrow[a]][x + xArrow[a]] = true;
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