package bj10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[][] dp=new int[testCase][10];
        for(int i=0; i<10; i++){
            dp[0][i]=1;
        }
        for(int i=1; i<testCase; i++){
            for(int j=0; j<10; j++){
                if(j-1>=0)
                    dp[i][j-1]=(dp[i][j-1]+dp[i-1][j])%1000000000;
                if(j+1<10)
                    dp[i][j+1]=(dp[i][j+1]+dp[i-1][j])%1000000000;
            }
        }
        int result=0;
        for(int i=1; i<10; i++){
            result=(result+dp[testCase-1][i])%1000000000;
        }
        System.out.println(result);
    }
}