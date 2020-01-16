package bj2292;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        int count=2;
        int compare=6;
        if(testCase==1){
            System.out.println(1);
            return;
        } else
            testCase-=1;
        while(testCase>compare){
            testCase-=compare;
            compare+=6;
            count++;
        }
        System.out.println(count);
    }
}