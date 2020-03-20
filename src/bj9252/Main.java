package bj9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputA=br.readLine().toCharArray();
        char[] inputB=br.readLine().toCharArray();
        int[][] dp=new int[inputB.length+1][inputA.length+1];
        for(int i=1; i<inputB.length+1; i++){
            for(int j=1; j<inputA.length+1; j++){
                if(inputA[j-1]==inputB[i-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[inputB.length][inputA.length]);
        Stack<Integer> result=new Stack<>();
        int xCursor=inputA.length;
        int yCursor=inputB.length;
        while(true){
            if(dp[yCursor][xCursor]==dp[yCursor][xCursor-1]){
                xCursor--;
            } else if(dp[yCursor][xCursor]==dp[yCursor-1][xCursor]){
                yCursor--;
            } else {
                result.push(yCursor);
                xCursor--;
                yCursor--;
            }
            if(yCursor==0||xCursor==0)
                break;
        }
        while(!result.isEmpty())
            System.out.print(inputB[result.pop()-1]);
    }
}