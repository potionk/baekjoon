package bj14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        int[] time=new int[testCase];
        int[] price=new int[testCase];
        int[] dp=new int[testCase];
        for(int i=0; i<testCase; i++){
            String[] readData=br.readLine().split(" ");
            time[i]= Integer.parseInt(readData[0]);
            price[i]= Integer.parseInt(readData[1]);
            if(i+time[i]<=testCase)
                dp[i]= price[i];
        }
        for(int i=1; i<testCase; i++){
            for(int j=0; j<i; j++){
                if(i-j>=time[j]&&i+time[i]<=testCase)
                    dp[i]=Math.max(dp[i], price[i]+dp[j]);
            }
        }
        int max=-1;
        for(int i=0; i<testCase; i++){
            max=Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}