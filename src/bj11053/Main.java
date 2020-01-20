package bj11053;

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
        int[] dp=new int[testCase.length];
        for(int i=0; i<testCaseStr.length; i++){
            testCase[i]= Integer.parseInt(testCaseStr[i]);
        }
        dp[0]=1;
        for(int i=1; i<testCase.length; i++){
            int max=-1;
            for(int j=0; j<i; j++){
                if(testCase[j]<testCase[i]&&dp[j]>max){
                    dp[i]=dp[j]+1;
                    max=dp[j];
                }
            }
            if(dp[i]==0)
                dp[i]=1;
        }
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
}