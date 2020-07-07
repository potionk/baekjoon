package bj2442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            for(int b=0; b<testCase-i-1; b++)
                System.out.print(" ");
            for(int s=0; s<i*2+1; s++)
                System.out.print("*");
            System.out.println();
        }
    }
}
