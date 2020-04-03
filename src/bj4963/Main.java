package bj4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] graph;
    static boolean[][] dfsIsVisited;
    static int graphX, graphY;
    static List<Integer> result;
    static int currentCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] testCase=br.readLine().split(" ");
            graphX = Integer.parseInt(testCase[0]);
            graphY = Integer.parseInt(testCase[1]);
            if(graphX == 0 && graphY == 0)
                break;
            graph=new int[graphY][graphX];
            dfsIsVisited=new boolean[graphY][graphX];
            result=new ArrayList<>();
            currentCount=0;
            for(int i = 0; i< graphY; i++){
                String[] input=br.readLine().split(" ");
                for(int j = 0; j< graphX; j++){
                    graph[i][j]= Integer.parseInt(input[j]);
                }
            }
            for(int i = 0; i< graphY; i++){
                for(int j = 0; j< graphX; j++){
                    if(graph[i][j]==1&&!dfsIsVisited[i][j]){
                        dfs(i, j);
                        result.add(currentCount);
                        currentCount=0;
                    }
                }
            }
            System.out.println(result.size());
        }
    }
    public static void dfs(int y, int x){
        dfsIsVisited[y][x]=true;
        currentCount++;
        if(!(y-1<0)&&graph[y-1][x]==1&&!dfsIsVisited[y-1][x])
            dfs(y-1,x);
        if(!(y+1>= graphY)&&graph[y+1][x]==1&&!dfsIsVisited[y+1][x])
            dfs(y+1,x);
        if(!(x-1<0)&&graph[y][x-1]==1&&!dfsIsVisited[y][x-1])
            dfs(y,x-1);
        if(!(x+1>= graphX)&&graph[y][x+1]==1&&!dfsIsVisited[y][x+1])
            dfs(y,x+1);

        if(!(y-1<0)&&!(x-1<0)&&graph[y-1][x-1]==1&&!dfsIsVisited[y-1][x-1])
            dfs(y-1,x-1);
        if(!(y+1>= graphY)&&!(x+1>= graphX)&&graph[y+1][x+1]==1&&!dfsIsVisited[y+1][x+1])
            dfs(y+1,x+1);
        if(!(y+1>= graphY)&&!(x-1<0)&&graph[y+1][x-1]==1&&!dfsIsVisited[y+1][x-1])
            dfs(y+1,x-1);
        if(!(y-1<0)&&!(x+1>= graphX)&&graph[y-1][x+1]==1&&!dfsIsVisited[y-1][x+1])
            dfs(y-1,x+1);
    }
}