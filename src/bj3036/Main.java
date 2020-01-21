package bj3036;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] inputStr=br.readLine().split(" ");
        int[] input=new int[inputStr.length];
        for(int i=0; i<input.length; i++){
            input[i]= Integer.parseInt(inputStr[i]);
        }
        for(int i=1; i<input.length; i++){
            int gcd=euclidean(input[0],input[i]);
            System.out.println(input[0]/gcd+"/"+input[i]/gcd);
        }
    }
    public static int euclidean(int a, int b){
        if(a%b==0)
            return b;
        else
            return euclidean(b,a%b);
    }
}