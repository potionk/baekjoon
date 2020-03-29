package bj2851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp=new int[10];
        dp[0]= Integer.parseInt(br.readLine());
        int result=dp[0];
        int minGap= Math.abs(100-dp[0]);
        for(int i=1; i<10; i++){
            dp[i]= Integer.parseInt(br.readLine())+dp[i-1];
            if(Math.abs(100-dp[i])<=minGap){
                minGap=Math.abs(100-dp[i]);
                result=dp[i];
            }
        }
        System.out.println(result);
    }
}