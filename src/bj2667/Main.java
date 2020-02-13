package bj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] graph;
    static boolean[][] dfsIsVisited;
    static int size;
    static List<Integer> result;
    static int currentCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size= Integer.parseInt(br.readLine());
        graph=new int[size][size];
        dfsIsVisited=new boolean[size][size];
        result=new ArrayList<>();
        currentCount=0;
        for(int i=0; i<size; i++){
            String input=br.readLine();
            for(int j=0; j<size; j++){
                graph[i][j]= Integer.parseInt(input.charAt(j)+"");
            }
        }
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(graph[i][j]==1&&!dfsIsVisited[i][j]){
                    dfs(i, j);
                    result.add(currentCount);
                    currentCount=0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
    public static void dfs(int y, int x){
        dfsIsVisited[y][x]=true;
        currentCount++;
        if(!(y-1<0)&&graph[y-1][x]==1&&!dfsIsVisited[y-1][x])
            dfs(y-1,x);
        if(!(y+1>=size)&&graph[y+1][x]==1&&!dfsIsVisited[y+1][x])
            dfs(y+1,x);
        if(!(x-1<0)&&graph[y][x-1]==1&&!dfsIsVisited[y][x-1])
            dfs(y,x-1);
        if(!(x+1>=size)&&graph[y][x+1]==1&&!dfsIsVisited[y][x+1])
            dfs(y,x+1);
    }
}