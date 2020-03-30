package bj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] dfsIsVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int vertexNum= Integer.parseInt(testCase[0]);
        int edgeNum= Integer.parseInt(testCase[1]);
        int count=0;
        graph=new ArrayList[vertexNum+1];
        for(int i=0; i<vertexNum+1; i++){
            graph[i]=new ArrayList<>();
        }
        dfsIsVisited=new boolean[vertexNum+1];
        for(int i=0; i<edgeNum; i++){
            String[] edge=br.readLine().split(" ");
            int a= Integer.parseInt(edge[0]);
            int b= Integer.parseInt(edge[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i=1; i<=vertexNum; i++){
            if(!dfsIsVisited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void dfs(int vertex){
        dfsIsVisited[vertex]=true;
        for(int i=0; i<graph[vertex].size(); i++){
            int nextVertex=graph[vertex].get(i);
            if(!dfsIsVisited[nextVertex]){
                dfs(nextVertex);
            }
        }
    }
}