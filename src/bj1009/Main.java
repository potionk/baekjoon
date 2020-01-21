package bj1009;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String[] input=br.readLine().split(" ");
            int a= Integer.parseInt(input[0]);
            int b= Integer.parseInt(input[1]);
            int result=a;
            for(int j=1; j<b; j++){
                result=(result*a)%10;
            }
            if(result==0)
                System.out.println(10);
            else
                System.out.println(result);
        }
    }
}