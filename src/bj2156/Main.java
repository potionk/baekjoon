package bj2156;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        int[] dp=new int[testCase];
        int[] stair=new int[testCase];
        for(int i=0; i<testCase; i++){
            stair[i]= Integer.parseInt(br.readLine());
        }
        dp[0]=stair[0];
        if(testCase>1)
            dp[1]=dp[0]+stair[1];
        if(testCase>2)
            dp[2]= Math.max(dp[0] + stair[2], stair[1] + stair[2]);
        for(int i=3; i<testCase; i++){
//            int caseOne=dp[i-3]+stair[i-1]+stair[i];
            int max=0;
            for(int j=3; i-j>=0; j++){
                if(dp[i-j]>max)
                    max=dp[i-j];
            }
            int caseOne=max+stair[i-1]+stair[i];
            int caseTwo=dp[i-2]+stair[i];

            if(caseOne>caseTwo)
                dp[i]=caseOne;
            else
                dp[i]=caseTwo;
        }
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
}