package bj1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[] count;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        count=new int[testCase+1];
        isVisited=new boolean[testCase+1];
        bfs(testCase);
    }
    public static void bfs(int start){
        LinkedList<Integer> queue = new LinkedList<>();
        count[start]=0;
        queue.add(start);
        while(!queue.isEmpty()){
            int p=queue.poll();
            if(p==1){
                System.out.println(count[p]);
                break;
            }
            if(p%3==0&&!isVisited[p/3]){
                queue.add(p/3);
                count[p/3]=count[p]+1;
                isVisited[p/3]=true;
            }
            if(p%2==0&&!isVisited[p/2]){
                queue.add(p/2);
                count[p/2]=count[p]+1;
                isVisited[p/2]=true;
            }
            if(p-1>1&&!isVisited[p-1]){
                queue.add(p-1);
                count[p-1]=count[p]+1;
                isVisited[p-1]=true;
            }
        }
    }
}