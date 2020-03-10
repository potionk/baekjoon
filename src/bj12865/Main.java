package bj12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int count= Integer.parseInt(testCase[0]);
        int weight= Integer.parseInt(testCase[1]);
        int[][] dp=new int[count][weight+1];
        for(int i=0; i<count; i++){
            String[] read=br.readLine().split(" ");
            int w= Integer.parseInt(read[0]);
            int v= Integer.parseInt(read[1]);
            for(int j=1; j<=weight; j++){
                if(i==0&&j>=w){
                    dp[i][j]=v;
                } else if(i>0){
                    if(j-w>=0)
                        dp[i][j]=Math.max(v+dp[i-1][j-w], dp[i-1][j]);
                    else
                        dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[count-1][weight]);
    }
}