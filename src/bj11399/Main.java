package bj11399;

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
        Arrays.sort(testCase);
        int total=0;
        for(int i=0; i<testCase.length; i++){
            for(int j=0; j<=i; j++){
                total+=testCase[j];
            }
        }
        System.out.println(total);
    }
}