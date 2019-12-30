package bj1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int zeroCount=0;
    static int oneCount=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        for(int i=0; i<size; i++){
            fibonacci(Integer.parseInt(br.readLine()));
            System.out.println(zeroCount+" "+oneCount);
            zeroCount=0;
            oneCount=0;
        }
    }
    public static int fibonacci(int n) {
        if (n == 0) {
            zeroCount++;
            return 0;
        } else if (n == 1) {
            oneCount++;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}