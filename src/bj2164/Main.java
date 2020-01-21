package bj2164;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=1; i<=testCase; i++){
            queue.add(i);
        }
        while(queue.size()!=1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.get(0));
    }
}