package bj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] graph;
    static boolean[][] bfsIsVisited;
    static int xSize, ySize;
    static int count;
    static int bfsTotal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        xSize = Integer.parseInt(testCase[0]);
        ySize = Integer.parseInt(testCase[1]);
        graph = new int[ySize][xSize];
        count = 0;
        int total = 0;
        bfsTotal=0;
        for (int i = 0; i < ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if (graph[i][j] != -1)
                    total++;
                if(graph[i][j]==1)
                    bfsTotal++;
            }
        }

        boolean isContinue=true;
        while(isContinue){
            bfsIsVisited = new boolean[ySize][xSize];
            isContinue=false;
            for (int i = 0; i < ySize; i++) {
                for (int j = 0; j < xSize; j++) {
                    if(graph[i][j]==1&&!bfsIsVisited[i][j]&&bfs(i,j)){
                        isContinue=true;
                    }
                }
            }
            if(isContinue)
                count++;
        }
        if(total!=bfsTotal)
            System.out.println(-1);
        else
            System.out.println(count);
    }

    public static boolean bfs(int y, int x) {
        boolean isExist = false;
        bfsIsVisited[y][x] = true;
        if (!(y + 1 >= ySize) && graph[y + 1][x] == 0 && !bfsIsVisited[y + 1][x]) {
            bfsIsVisited[y + 1][x] = true;
            graph[y+1][x]=1;
            bfsTotal++;
            isExist = true;
        }
        if (!(x + 1 >= xSize) && graph[y][x + 1] == 0 && !bfsIsVisited[y][x + 1]) {
            bfsIsVisited[y][x + 1] = true;
            graph[y][x+1]=1;
            bfsTotal++;
            isExist = true;
        }
        if (!(y - 1 < 0) && graph[y - 1][x] == 0 && !bfsIsVisited[y - 1][x]) {
            bfsIsVisited[y - 1][x] = true;
            graph[y-1][x]=1;
            bfsTotal++;
            isExist = true;
        }
        if (!(x - 1 < 0) && graph[y][x - 1] == 0 && !bfsIsVisited[y][x - 1]) {
            bfsIsVisited[y][x - 1] = true;
            graph[y][x-1]=1;
            bfsTotal++;
            isExist = true;
        }
        return isExist;
    }
}