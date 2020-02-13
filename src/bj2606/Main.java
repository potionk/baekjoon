package bj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] dfsIsVisited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertexNum= Integer.parseInt(br.readLine());
        int edgeNum= Integer.parseInt(br.readLine());
        count=0;
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
//        for(int i=1; i<vertexNum+1; i++){
////            Collections.sort(graph[i]);
////        }
        dfs(1);
        System.out.println(count-1);
    }
    public static void dfs(int vertex){
        count++;
        dfsIsVisited[vertex]=true;
        for(int i=0; i<graph[vertex].size(); i++){
            int nextVertex=graph[vertex].get(i);
            if(!dfsIsVisited[nextVertex]){
                dfs(nextVertex);
            }
        }
    }
}