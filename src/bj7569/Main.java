package bj7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int[][][] graph;
    static int count;
    static int xSize, ySize, zSize;
    static int totalNonMinusOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        xSize = Integer.parseInt(testCase[0]);
        ySize = Integer.parseInt(testCase[1]);
        zSize = Integer.parseInt(testCase[2]);
        ArrayList<XYZ> list = new ArrayList<>();
        count = 0;
        int nonMinusOne = 0;
        totalNonMinusOne = 0;
        graph = new int[zSize][ySize][xSize];
        for (int k = 0; k < zSize; k++) {
            for (int i = 0; i < ySize; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < input.length; j++) { // xSize
                    graph[k][i][j] = Integer.parseInt(input[j]);
                    if (graph[k][i][j] == 1) {
                        list.add(new XYZ(j, i, k));
                        totalNonMinusOne++;
                    }
                    if (graph[k][i][j] != -1)
                        nonMinusOne++;

                }
            }
        }
        bfs(list);
        if (totalNonMinusOne != nonMinusOne) {
            System.out.println(-1);
            return;
        }
        System.out.println(count);
    }

    public static void bfs(ArrayList<XYZ> list) {
        LinkedList<XYZ> queue = new LinkedList<>(list);
        boolean isContinue = true;
        while (isContinue) {
            isContinue = false;
            int beforeQueueSize = queue.size();
            for (int i = 0; i < beforeQueueSize; i++) {
                XYZ next = queue.poll();
                int x = next.getX();
                int y = next.getY();
                int z = next.getZ();
                if (!(y + 1 >= ySize) && graph[z][y + 1][x] == 0) {
                    queue.add(new XYZ(x, y + 1, z));
                    graph[z][y + 1][x] = 1;
                    isContinue = true;
                    totalNonMinusOne++;
                }
                if (!(x + 1 >= xSize) && graph[z][y][x + 1] == 0) {
                    queue.add(new XYZ(x + 1, y, z));
                    graph[z][y][x + 1] = 1;
                    isContinue = true;
                    totalNonMinusOne++;
                }
                if (!(z + 1 >= zSize) && graph[z + 1][y][x] == 0) {
                    queue.add(new XYZ(x, y, z + 1));
                    graph[z + 1][y][x] = 1;
                    isContinue = true;
                    totalNonMinusOne++;
                }
                if (!(y - 1 < 0) && graph[z][y - 1][x] == 0) {
                    queue.add(new XYZ(x, y - 1, z));
                    graph[z][y - 1][x] = 1;
                    isContinue = true;
                    totalNonMinusOne++;
                }
                if (!(x - 1 < 0) && graph[z][y][x - 1] == 0) {
                    queue.add(new XYZ(x - 1, y, z));
                    graph[z][y][x - 1] = 1;
                    isContinue = true;
                    totalNonMinusOne++;
                }
                if (!(z - 1 < 0) && graph[z - 1][y][x] == 0) {
                    queue.add(new XYZ(x, y, z - 1));
                    graph[z - 1][y][x] = 1;
                    isContinue = true;
                    totalNonMinusOne++;
                }
            }
            if (isContinue)
                count++;
        }
    }
}

class XYZ {
    int x;
    int y;
    int z;

    public XYZ(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}