package bj11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] dfsIsVisited;
    static Map<Integer, Integer> parentMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        parentMap=new HashMap<>();
        int nodeNum= Integer.parseInt(br.readLine());
        tree =new ArrayList[nodeNum+1];
        for(int i=0; i<nodeNum+1; i++){
            tree[i]=new ArrayList<>();
        }
        dfsIsVisited=new boolean[nodeNum+1];
        for(int i=0; i<nodeNum-1; i++){
            String[] edge=br.readLine().split(" ");
            int a= Integer.parseInt(edge[0]);
            int b= Integer.parseInt(edge[1]);
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1);
        for(int i=2; i<=nodeNum; i++){
            System.out.println(parentMap.get(i));
        }
    }
    public static void dfs(int vertex){
        dfsIsVisited[vertex]=true;
        for(int i = 0; i< tree[vertex].size(); i++){
            int nextVertex= tree[vertex].get(i);
            if(!dfsIsVisited[nextVertex]){
                parentMap.put(nextVertex, vertex);
                dfs(nextVertex);
            }
        }
    }
}