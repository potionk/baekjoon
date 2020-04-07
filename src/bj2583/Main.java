package bj2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] graph;
    static boolean[][] dfsIsVisited;
    static int xSize, ySize;
    static List<Integer> result;
    static int currentCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        xSize= Integer.parseInt(testCase[0]);
        ySize= Integer.parseInt(testCase[1]);
        int k= Integer.parseInt(testCase[2]);
        graph=new int[ySize][xSize];
        dfsIsVisited=new boolean[ySize][xSize];
        result=new ArrayList<>();
        for(int i=0; i<k; i++){
            String[] input=br.readLine().split(" ");
            int sX= Integer.parseInt(input[0]);
            int sY= Integer.parseInt(input[1]);
            int fX= Integer.parseInt(input[2]);
            int fY= Integer.parseInt(input[3]);
            for(int y=sY; y<fY; y++){
                for(int x=sX; x<fX; x++){
                    graph[x][y]=1;
                }
            }
        }

        for(int i=0; i<ySize; i++){
            for(int j=0; j<xSize; j++){
                if(graph[i][j]==0&&!dfsIsVisited[i][j]){
                    dfs(i, j);
                    result.add(currentCount);
                    currentCount=0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
    public static void dfs(int y, int x){
        dfsIsVisited[y][x]=true;
        currentCount++;
        if(!(y-1<0)&&graph[y-1][x]==0&&!dfsIsVisited[y-1][x])
            dfs(y-1,x);
        if(!(y+1>=ySize)&&graph[y+1][x]==0&&!dfsIsVisited[y+1][x])
            dfs(y+1,x);
        if(!(x-1<0)&&graph[y][x-1]==0&&!dfsIsVisited[y][x-1])
            dfs(y,x-1);
        if(!(x+1>=xSize)&&graph[y][x+1]==0&&!dfsIsVisited[y][x+1])
            dfs(y,x+1);
    }
}
