package bj1389;

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
        String[] testCase=br.readLine().split(" ");
        int vertexNum= Integer.parseInt(testCase[0]);
        int edgeNum= Integer.parseInt(testCase[1]);
        int result= Integer.MAX_VALUE;
        int assa=-1;
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
        for(int i=vertexNum; i>=1; i--){
            int bfsResult=bfs(i);
            if(bfsResult<=result){
                result=bfsResult;
                assa=i;
            }
            bfsIsVisited=new boolean[vertexNum+1];
        }
        System.out.println(assa);
    }


    public static int bfs(int vertex){
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(vertex);
        bfsIsVisited[vertex]=true;
        int count=-1;
        int kevin=0;
        while(queue.size()!=0){
            int queueSize=queue.size();
            count++;
            for(int q=0; q<queueSize; q++){
                int p=queue.poll();
                kevin+=count;
                for(int i=0; i<graph[p].size(); i++){
                    int nextVertex=graph[p].get(i);
                    if(!bfsIsVisited[nextVertex]){
                        queue.add(nextVertex);
                        bfsIsVisited[nextVertex]=true;
                    }
                }
            }
        }
        return kevin;
    }
}