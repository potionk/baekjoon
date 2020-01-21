package bj1912;

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
        dp[0]=testCase[0];
        for(int i=1; i<testCase.length; i++){
            int caseOne=dp[i-1]+testCase[i];
            int caseTwo=testCase[i-1]+testCase[i];
            int caseThree=testCase[i];
            int max=max(caseOne,caseTwo,caseThree);
            dp[i]=max;
        }
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
    }
    public static int max(int a, int b, int c){
        int max=Integer.MIN_VALUE;
        if(a>max)
            max=a;
        if(b>max)
            max=b;
        if(c>max)
            max=c;
        return max;
    }
}