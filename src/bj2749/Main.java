package bj2749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] fibo=new long[1500001];
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long input=Long.parseLong(br.readLine());
        System.out.println(fibo[(int)(input%1500000)]);
    }
    public static void init() {
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i=2; i<=1500000; i++) {
            fibo[i]=(fibo[i-1]+fibo[i-2])%1000000;
        }
    }
}