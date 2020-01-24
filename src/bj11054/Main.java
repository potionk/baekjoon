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
        int tcLen=testCase.length;
        int[] incDp=new int[tcLen];
        int[] decDp=new int[tcLen];
        int[] result=new int[tcLen+1];
        for(int i=0; i<tcLen; i++){
            testCase[i]= Integer.parseInt(testCaseStr[i]);
        }
        incDp[0]=1;
        decDp[decDp.length-1]=1;
        for(int i=1; i<tcLen; i++){
            int max=-1;
            for(int j=0; j<i; j++){
                if(testCase[j]<testCase[i]&&incDp[j]>max){
                    incDp[i]=incDp[j]+1;
                    max=incDp[j];
                }
            }
            if(incDp[i]==0)
                incDp[i]=1;
        }

        for(int i=decDp.length-2; i>=0; i--){
            int max=-1;
            for(int j=decDp.length-1; j>i; j--){
                if(testCase[j]<testCase[i]&&decDp[j]>max){
                    decDp[i]=decDp[j]+1;
                    max=decDp[j];
                }
            }
            if(decDp[i]==0)
                decDp[i]=1;
        }
        for(int i=0; i<tcLen-1; i++){
            if(incDp[i]==1&&decDp[i+1]==1)
                result[i]=1;
            else{
                int base=incDp[i]+decDp[i+1];
                if(testCase[i]==testCase[i+1])
                    result[i]=base-1;
                else
                    result[i]=base;
            }

        }
        result[tcLen-1]=decDp[0];
        result[tcLen]=incDp[incDp.length-1];
        Arrays.sort(result);
        System.out.println(result[result.length-1]);
    }
}