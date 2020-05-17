package bj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int N= Integer.parseInt(testCase[0]);
        int K= Integer.parseInt(testCase[1]);
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=1; i<=N; i++)
            list.add(i);
        int index=-1;
        System.out.print("<");
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                index++;
                if(index==list.size())
                    index=0;
            }
            int rem=list.remove(index);
            index--;
            if(i!=N-1)
                System.out.print(rem+", ");
            else
                System.out.print(rem);
        }
        System.out.print(">");
    }
}