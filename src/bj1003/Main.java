package bj1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] fiboZero=new int[41];
    static int[] fiboOne=new int[41];
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        for(int i=0; i<size; i++){
            int input=Integer.parseInt(br.readLine());
            System.out.println(fiboZero[input]+" "+fiboOne[input]);
        }
    }
    public static void init() {
        fiboZero[0] = 1;
        fiboOne[0] = 0;
        fiboZero[1] = 0;
        fiboOne[1] = 1;
        for (int i=2; i<=40; i++) {
            fiboZero[i]=fiboZero[i-1]+fiboZero[i-2];
            fiboOne[i]=fiboOne[i-1]+fiboOne[i-2];
        }
    }
}