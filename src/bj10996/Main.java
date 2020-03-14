package bj10996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            for(int j=0; j<testCase; j++){
                if(!(j%2==0))
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
            for(int j=0; j<testCase; j++){
                if((j%2==0))
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}