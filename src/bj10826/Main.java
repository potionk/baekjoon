package bj10826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger[] fibo=new BigInteger[10001];
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input=Integer.parseInt(br.readLine());
        System.out.println(fibo[input]);
    }
    public static void init() {
        fibo[0]=BigInteger.ZERO;
        fibo[1]=BigInteger.ONE;
        for (int i=2; i<=10000; i++) {
            fibo[i]=fibo[i-1].add(fibo[i-2]);
        }
    }
}