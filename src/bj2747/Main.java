package bj2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] fibo=new long[46];
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input=Integer.parseInt(br.readLine());
        System.out.println(fibo[input]);
    }
    public static void init() {
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i=2; i<=45; i++) {
            fibo[i]=fibo[i-1]+fibo[i-2];
        }
    }
}