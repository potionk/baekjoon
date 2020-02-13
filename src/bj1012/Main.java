package bj1012;

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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum= Integer.parseInt(br.readLine());
        for(int k=0; k<testCaseNum; k++){
            String[] input=br.readLine().split(" ");
            int tc=Integer.parseInt(input[2]);
            xSize= Integer.parseInt(input[0]);
            ySize= Integer.parseInt(input[1]);
            graph=new int[ySize][xSize];
            dfsIsVisited=new boolean[ySize][xSize];
            result=new ArrayList<>();
            for(int i=0; i<tc; i++){
                String[] readTC=br.readLine().split(" ");
                graph[Integer.parseInt(readTC[1])][Integer.parseInt(readTC[0])]=1;
            }
            for(int i=0; i<ySize; i++){
                for(int j=0; j<xSize; j++){
                    if(graph[i][j]==1&&!dfsIsVisited[i][j]){
                        dfs(i, j);
                        result.add(1);
                    }
                }
            }
            System.out.println(result.size());
        }
    }
    public static void dfs(int y, int x){
        dfsIsVisited[y][x]=true;
        if(!(y-1<0)&&graph[y-1][x]==1&&!dfsIsVisited[y-1][x])
            dfs(y-1,x);
        if(!(y+1>=ySize)&&graph[y+1][x]==1&&!dfsIsVisited[y+1][x])
            dfs(y+1,x);
        if(!(x-1<0)&&graph[y][x-1]==1&&!dfsIsVisited[y][x-1])
            dfs(y,x-1);
        if(!(x+1>=xSize)&&graph[y][x+1]==1&&!dfsIsVisited[y][x+1])
            dfs(y,x+1);
    }
}