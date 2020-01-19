package bj9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] pado=new long[100];
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int input=Integer.parseInt(br.readLine());
            System.out.println(pado[input-1]);
        }
    }
    public static void init() {
        pado[0] = 1;
        pado[1] = 1;
        pado[2] = 1;
        pado[3] = 2;
        pado[4] = 2;
        for (int i=5; i<100; i++) {
            pado[i]=pado[i-1]+pado[i-5];
        }
    }
}