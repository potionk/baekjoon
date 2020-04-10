package bj9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static XY[] cStore;
    static XY start, finish;
    static boolean[][] dfsIsVisited;
    static int[] dfsDirectionX, dfsDirectionY;
    static int minX, maxX, minY, maxY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        dfsDirectionX = new int[]{1, 0, -1, 0};
        dfsDirectionY = new int[]{0, -1, 0, 1};
        for (int i = 0; i < testCase; i++) {
            dfsIsVisited = new boolean[1312][1312];
            int cStoreNum = Integer.parseInt(br.readLine());
            cStore = new XY[cStoreNum];
            String[] startStr = br.readLine().split(" ");
            int startX = meter2index(Integer.parseInt(startStr[0])), startY = meter2index(Integer.parseInt(startStr[1]));
            initMinMax(startX, startY);
            start = new XY(startX, startY);
            for (int j = 0; j < cStoreNum; j++) {
                String[] cStoreStr = br.readLine().split(" ");
                int cStoreX = meter2index(Integer.parseInt(cStoreStr[0])), cStoreY = meter2index(Integer.parseInt(cStoreStr[1]));
                calMinMax(cStoreX, cStoreY);
                cStore[j] = new XY(cStoreX, cStoreY);
            }
            String[] finishStr = br.readLine().split(" ");
            int finishX = meter2index(Integer.parseInt(finishStr[0])), finishY = meter2index(Integer.parseInt(finishStr[1]));
            calMinMax(finishX, finishY);
            finish = new XY(finishX, finishY);
            dfs(startY, startX, 20);
            if(dfsIsVisited[finishY][finishX])
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }

    public static void dfs(int y, int x, int beer) {
        dfsIsVisited[y][x] = true;
        for (int i = 0; i < cStore.length; i++) {
            if (cStore[i].getX() == x && cStore[i].getY() == y) {
                beer = 20;
                break;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (beer>0&&!(x + dfsDirectionX[i] < minX) && !(y + dfsDirectionY[i] < minY) && !(x + dfsDirectionX[i] > maxX) && !(y + dfsDirectionY[i] > maxY) && !dfsIsVisited[y + dfsDirectionY[i]][x + dfsDirectionX[i]]) {
                dfs(y + dfsDirectionY[i], x + dfsDirectionX[i], beer - 1);
            }
        }
    }

    public static int meter2index(int input) {
        int unsigned = input + 32768;
        return unsigned / 50;
    }

    public static void calMinMax(int x, int y) {
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        minY = Math.min(minY, x);
        maxY = Math.max(maxY, x);
    }

    public static void initMinMax(int x, int y) {
        minX = x;
        maxX = x;
        minY = y;
        maxY = y;
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