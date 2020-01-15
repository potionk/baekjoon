package bj2846;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> max=new LinkedList<>();
        br.readLine();
        String[] testCaseStr= br.readLine().split(" ");
        int[] testCase=new int[testCaseStr.length];
        for(int i=0; i<testCaseStr.length; i++){
            testCase[i]= Integer.parseInt(testCaseStr[i]);
        }
        int saveData=testCase[0];
        for(int i=1; i<testCase.length; i++){
            if(testCase[i-1]<testCase[i]){
                if(i==testCase.length-1)
                    max.add(testCase[i]-saveData);
            }
            else{
                max.add(testCase[i-1]-saveData);
                saveData=testCase[i];
            }
        }
        Object[] maxArray=max.toArray();
        Arrays.sort(maxArray);
        System.out.println((int)maxArray[maxArray.length-1]);
    }
}