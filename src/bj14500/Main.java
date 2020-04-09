package bj14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int[][] paper;
    static boolean[][] dfsIsVisited;
    static int xSize, ySize;
    static List<Integer> countList;
    static int[] dfsDirectionX;
    static int[] dfsDirectionY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        ySize = Integer.parseInt(testCase[0]);
        xSize = Integer.parseInt(testCase[1]);
        paper = new int[ySize][xSize];
        dfsIsVisited = new boolean[ySize][xSize];
        countList = new LinkedList<>();
        dfsDirectionX = new int[]{1, 0, -1, 0};
        dfsDirectionY = new int[]{0, -1, 0, 1};
        for (int i = 0; i < ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++)
                paper[i][j] = Integer.parseInt(input[j]);
        }
        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                dfs(i, j, 1, 0);
            }
        }
        findExceptionBlock();
        Collections.sort(countList);
        System.out.println(countList.get(countList.size()-1));
    }

    public static void dfs(int y, int x, int count, int sum) {
        sum += paper[y][x];
        if (count == 4){
            countList.add(sum);
            return;
        }
        dfsIsVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if (!(x + dfsDirectionX[i] < 0) && !(y + dfsDirectionY[i] < 0) && !(x + dfsDirectionX[i] >= xSize) && !(y + dfsDirectionY[i] >= ySize) && !dfsIsVisited[y + dfsDirectionY[i]][x + dfsDirectionX[i]]) {
                dfs(y + dfsDirectionY[i], x + dfsDirectionX[i], count + 1, sum);
            }
        }
        dfsIsVisited[y][x] = false;
    }
    public static void findExceptionBlock(){ // find ㅗ, ㅏ, ㅓ, ㅜ block
        for(int i=0; i<=ySize-3; i++){
            for(int j=0; j<=xSize-2; j++){
                countList.add(paper[i][j]+paper[i+1][j]+paper[i+1][j+1]+paper[i+2][j]); // ㅏ
                countList.add(paper[i][j+1]+paper[i+1][j+1]+paper[i+1][j]+paper[i+2][j+1]); // ㅓ
            }
        }
        for(int i=0; i<=ySize-2; i++){
            for(int j=0; j<=xSize-3; j++){
                countList.add(paper[i][j]+paper[i][j+1]+paper[i][j+2]+paper[i+1][j+1]); // ㅜ
                countList.add(paper[i+1][j]+paper[i+1][j+1]+paper[i][j+1]+paper[i+1][j+2]); // ㅗ
            }
        }
    }
}