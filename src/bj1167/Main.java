package bj1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static ArrayList<Node>[] tree;
    static boolean[] dfsIsVisited;
    static Map<Integer, Integer> weightMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        weightMap=new HashMap<>();
        int nodeNum= Integer.parseInt(br.readLine());
        tree =new ArrayList[nodeNum+1];
        for(int i=0; i<nodeNum+1; i++){
            tree[i]=new ArrayList<>();
        }
        dfsIsVisited=new boolean[nodeNum+1];
        for(int i=0; i<nodeNum; i++){
            String[] edge=br.readLine().split(" ");
            int a= Integer.parseInt(edge[0]);
            int bIndex=1;
            int weightIndex=2;
            while(weightIndex<edge.length){
                int b= Integer.parseInt(edge[bIndex]);
                int weight= Integer.parseInt(edge[weightIndex]);
                tree[a].add(new Node(b, weight));
                tree[b].add(new Node(a, weight));
                bIndex+=2;
                weightIndex+=2;
            }
        }
        dfs(1,0);
        int max=-1;
        int maxIndex=-1;
        for(int i=1; i<=nodeNum; i++){
            int next;
            if(weightMap.get(i)!=null&&(next=weightMap.get(i))>max){
                max=next;
                maxIndex=i;
            }

        }
        weightMap=new HashMap<>();
        dfsIsVisited=new boolean[nodeNum+1];
        dfs(maxIndex,0);
        for(int i=1; i<=nodeNum; i++){
            int next;
            if(weightMap.get(i)!=null&&(next=weightMap.get(i))>max)
                max=next;
        }
        System.out.println(max);
    }
    public static void dfs(int vertex, int weight){
        dfsIsVisited[vertex]=true;
        for(int i = 0; i< tree[vertex].size(); i++){
            Node next= tree[vertex].get(i);
            int nextVertex=next.getData();
            int nextWeight=next.getWeight();
            if(!dfsIsVisited[nextVertex]){
                weightMap.put(nextVertex, weight+nextWeight);
                dfs(nextVertex, weight+nextWeight);
            }
        }
    }
}

class Node{
    int data;
    int weight;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    Node(int data, int weight){
        this.data=data;
        this.weight=weight;
    }
}