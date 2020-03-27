package bj11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input=Integer.parseInt(br.readLine());
        fibo=new long[input+2];
        dp(input+1);
        System.out.println(fibo[input+1]);
    }
    public static void dp(int max) {
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i=2; i<=max; i++) {
            fibo[i]=(fibo[i-1]+fibo[i-2])%10007;
        }
    }
}