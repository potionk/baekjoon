package bj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static LinkedList<Integer> queue;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue=new LinkedList<>();
        count=0;
        String[] nm=br.readLine().split(" ");
        String[] findTargetStr=br.readLine().split(" ");
        int[] findTarget=new int[findTargetStr.length];
        for(int i=0; i<findTarget.length; i++){
            findTarget[i]= Integer.parseInt(findTargetStr[i]);
        }
        int N= Integer.parseInt(nm[0]);
        int M= Integer.parseInt(nm[1]);
        for(int i=1; i<=N; i++)
            queue.add(i);
        for(int i=0; i<M; i++){
            int index=findIndex(findTarget[i]);
            if(index<=queue.size()/2){
                for(int j=0; j<index; j++)
                    rotateLeft();
            } else {
                for(int j=0; j<queue.size()-index; j++)
                    rotateRight();
            }
            queue.poll();
        }
        System.out.println(count);
    }
    public static void rotateLeft(){ // 2번
        if(!queue.isEmpty()){
            queue.add(queue.poll());
            count++;
        }
    }

    public static void rotateRight(){ // 3번
        if(!queue.isEmpty()){
            queue.push(queue.remove(queue.size()-1));
            count++;
        }
    }

    public static int findIndex(int input){
        for(int i=0; i<queue.size(); i++){
            if(queue.get(i)==input)
                return i;
        }
        return -1;
    }
}