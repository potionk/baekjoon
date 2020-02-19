package bj1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static boolean[] isVisited;
    static int[] count;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int start= Integer.parseInt(testCase[0]);
        int finish= Integer.parseInt(testCase[1]);
        size= Math.max(start, finish);
        isVisited=new boolean[size*2+1];
        count=new int[size*2+1];
        if(start==finish){
            System.out.println(0);
            return;
        }
        bfs(start);
        System.out.println(count[finish]);
    }
    public static void bfs(int start){
        LinkedList<Integer> queue = new LinkedList<>();
        count[start]=0;
        queue.add(start);
        while(!queue.isEmpty()){
            int p=queue.poll();
            if(!(p-1<0)&&!isVisited[p-1]){
                queue.add(p-1);
                isVisited[p-1]=true;
                count[p-1]=count[p]+1;
            }
            if(!(p+1>=size*2)&&!isVisited[p+1]){
                queue.add(p+1);
                isVisited[p+1]=true;
                count[p+1]=count[p]+1;
            }
            if(!(p*2>=size*2)&&!isVisited[p*2]){
                queue.add(p*2);
                isVisited[p*2]=true;
                count[p*2]=count[p]+1;
            }
        }
    }
}