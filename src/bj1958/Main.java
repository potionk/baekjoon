package bj1958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputA=br.readLine().toCharArray();
        char[] inputB=br.readLine().toCharArray();
        char[] inputC=br.readLine().toCharArray();
        int[][][] dp=new int[inputC.length+1][inputB.length+1][inputA.length+1];
        for(int k=1; k<inputC.length+1; k++){
            for(int i=1; i<inputB.length+1; i++){
                for(int j=1; j<inputA.length+1; j++){
                    if(inputA[j-1]==inputB[i-1]&&inputB[i-1]==inputC[k-1]){
                        dp[k][i][j]=dp[k-1][i-1][j-1]+1;
                    } else {
                        dp[k][i][j]=Math.max(dp[k][i-1][j], dp[k][i][j-1]);
                        dp[k][i][j]=Math.max(dp[k][i][j], dp[k-1][i][j]);
                    }
                }
            }
        }
        System.out.println(dp[inputC.length][inputB.length][inputA.length]);
    }
}