package bj6359;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int num=Integer.parseInt(br.readLine());
            boolean[] room=new boolean[num];
            for(int j=2; j<=num; j++){
                for(int k=j; k<=num; k+=j){
                    if(k>num)
                        break;
                    room[k-1]=!room[k-1];
                }

            }
            int result=0;
            for(int j=0; j<num; j++){
                if(!room[j])
                    result++;
            }
            System.out.println(result);
        }
    }
}