package bj5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] bfsIsVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertexNum= Integer.parseInt(br.readLine());
        int edgeNum= Integer.parseInt(br.readLine());
        graph=new ArrayList[vertexNum+1];
        for(int i=0; i<vertexNum+1; i++){
            graph[i]=new ArrayList<>();
        }
        bfsIsVisited=new boolean[vertexNum+1];
        for(int i=0; i<edgeNum; i++){
            String[] edge=br.readLine().split(" ");
            int a= Integer.parseInt(edge[0]);
            int b= Integer.parseInt(edge[1]);
            graph[a].add(b);
            graph[b].add(a);
        }
        bfs(1);
    }


    public static void bfs(int vertex){
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(vertex);
        bfsIsVisited[vertex]=true;
        int count=0;
        int invite=0;
        while(queue.size()!=0){
            int queueSize=queue.size();
            if(++count>3)
                break;
            for(int q=0; q<queueSize; q++){
                int p=queue.poll();
                invite++;
                for(int i=0; i<graph[p].size(); i++){
                    int nextVertex=graph[p].get(i);
                    if(!bfsIsVisited[nextVertex]){
                        queue.add(nextVertex);
                        bfsIsVisited[nextVertex]=true;
                    }
                }
            }
        }
        System.out.println(invite-1);
    }
}