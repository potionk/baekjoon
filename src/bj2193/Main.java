package bj2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] result=new long[num];
        result[0]=1;
        if(num!=1)
            result[1]=1;
        for(int i=2; i<num; i++){
            result[i]=result[i-1]+result[i-2];
        }
        System.out.println(result[num-1]);
    }
}