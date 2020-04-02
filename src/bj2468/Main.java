package bj2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] floodMap;
    static boolean[][] dfsIsVisited;
    static int size;
    static int max, min;
    static int resultMax;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        map=new int[size][size];
        floodMap=new boolean[size][size];
        max= Integer.MIN_VALUE;
        min= Integer.MAX_VALUE;
        resultMax= Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            String[] input=br.readLine().split(" ");
            for(int j=0; j<size; j++){
                map[i][j]= Integer.parseInt(input[j]);
                min=Math.min(min, map[i][j]);
                max=Math.max(max, map[i][j]);
            }
        }
        for(int i=min-1; i<=max; i++){
            dfsIsVisited=new boolean[size][size];
            result=new LinkedList<>();
            for(int y=0; y<size; y++){
                for(int x=0; x<size; x++){
                    if(map[y][x]<=i){
                        floodMap[y][x]=true;
                    } else
                        floodMap[y][x]=false;
                }
            }
            for(int y=0; y<size; y++){
                for(int x=0; x<size; x++){
                    if(!floodMap[y][x]&&!dfsIsVisited[y][x]){
                        dfs(y, x);
                        result.add(1);
                    }
                }
            }
            resultMax=Math.max(resultMax, result.size());
        }

        System.out.println(resultMax);
    }
    public static void dfs(int y, int x){
        dfsIsVisited[y][x]=true;
        if(!(y-1<0)&&!floodMap[y-1][x]&&!dfsIsVisited[y-1][x])
            dfs(y-1,x);
        if(!(y+1>= size)&&!floodMap[y+1][x]&&!dfsIsVisited[y+1][x])
            dfs(y+1,x);
        if(!(x-1<0)&&!floodMap[y][x-1]&&!dfsIsVisited[y][x-1])
            dfs(y,x-1);
        if(!(x+1>= size)&&!floodMap[y][x+1]&&!dfsIsVisited[y][x+1])
            dfs(y,x+1);
    }
}