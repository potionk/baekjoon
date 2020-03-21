package bj11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] testCaseStr=br.readLine().split(" ");
        int[] testCase=new int[testCaseStr.length];
        for(int i=0; i<testCaseStr.length; i++){
            testCase[i]= Integer.parseInt(testCaseStr[i]);
        }
        int[] dp=lis(testCase);
        int[] reverseDP=reverseLis(testCase);
        int[] sumDP=new int[dp.length];
        for(int i=0; i<dp.length; i++){
            sumDP[i]=dp[i]+reverseDP[i];
        }
        Arrays.sort(sumDP);
        System.out.println(sumDP[sumDP.length-1]-1);
    }
    public static int[] lis(int[] tc){
        int[] dp=new int[tc.length];
        dp[0]=1;
        for(int i=1; i<tc.length; i++){
            int max=-1;
            for(int j=0; j<i; j++){
                if(tc[j]<tc[i]&&dp[j]>max){
                    dp[i]=dp[j]+1;
                    max=dp[j];
                }
            }
            if(dp[i]==0)
                dp[i]=1;
        }
        return dp;
    }

    public static int[] reverseLis(int[] tc){
        int[] dp=new int[tc.length];
        dp[dp.length-1]=1;
        for(int i=dp.length-1; i>=0; i--){
            int max=-1;
            for(int j=dp.length-1; j>i; j--){
                if(tc[j]<tc[i]&&dp[j]>max){
                    dp[i]=dp[j]+1;
                    max=dp[j];
                }
            }
            if(dp[i]==0)
                dp[i]=1;
        }
        return dp;
    }
}