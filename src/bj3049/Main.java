package bj3049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input=Integer.parseInt(br.readLine());
        int a=1;
        int b=1;
        for(int i=0; i<4; i++){
            a*=input--;
            b*=(i+1);
        }
        System.out.println(a/b);
    }
}