package bj10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(fibo(input));
    }
    public static int fibo(int input){
        if(input==0)
            return 0;
        if(input==1)
            return 1;
        else
            return fibo(input-2)+fibo(input-1);
    }
}
