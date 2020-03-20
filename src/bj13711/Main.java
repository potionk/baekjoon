package bj13711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] inputA=br.readLine().split(" ");
        String[] inputB=br.readLine().split(" ");
        int[][] dp=new int[inputB.length+1][inputA.length+1];
        for(int i=1; i<inputB.length+1; i++){
            for(int j=1; j<inputA.length+1; j++){
                if(inputA[j-1].equals(inputB[i-1])){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[inputB.length][inputA.length]);
    }
}