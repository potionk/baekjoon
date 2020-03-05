package bj1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] graph;
    static boolean[][] dfsIsVisited;
    static int xSize, ySize;
    static List<Integer> result;
    static boolean[] isAlphabetUsed;
    static int max;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        xSize = Integer.parseInt(input[1]);
        ySize = Integer.parseInt(input[0]);
        graph = new int[ySize][xSize];
        dfsIsVisited = new boolean[ySize][xSize];
        isAlphabetUsed=new boolean[26];
        max=1;
        count=1;
        result = new ArrayList<>();
        for (int i = 0; i < ySize; i++) {
            char[] read=br.readLine().toCharArray();
            for(int j=0; j<xSize; j++){
                graph[i][j]=(int)read[j]-65;
            }
        }
        dfs(0, 0);

        System.out.println(max);
    }

    public static void dfs(int y, int x) {
        dfsIsVisited[y][x] = true;
        isAlphabetUsed[graph[y][x]]=true;
        if (!(y - 1 < 0) && !dfsIsVisited[y - 1][x]){
            if(!isAlphabetUsed[graph[y-1][x]]){
                max=Math.max(++count,max);
                dfs(y - 1, x);
            }
        }
        if (!(y + 1 >= ySize)&& !dfsIsVisited[y + 1][x]){
            if(!isAlphabetUsed[graph[y+ 1][x]]){
                max=Math.max(++count,max);
                dfs(y+ 1, x);
            }
        }
        if (!(x - 1 < 0) && !dfsIsVisited[y][x - 1]){
            if(!isAlphabetUsed[graph[y][x-1]]){
                max=Math.max(++count,max);
                dfs(y, x - 1);
            }
        }
        if (!(x + 1 >= xSize) && !dfsIsVisited[y][x + 1]){
            if(!isAlphabetUsed[graph[y][x+1]]){
                max=Math.max(++count,max);
                dfs(y, x + 1);
            }
        }
        count--;
        isAlphabetUsed[graph[y][x]]=false;
        dfsIsVisited[y][x]=false;
    }
}