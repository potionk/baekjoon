package bj1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split("-");
        int total=0;
        boolean isExistMinus=false;
        if(testCase.length>1){
            total= Integer.parseInt(testCase[0]);
            isExistMinus=true;
        }
        int i;
        if(isExistMinus)
            i=1;
        else
            i=0;
        for(; i<testCase.length; i++){
            String[] subTotal=testCase[i].split("\\+");
            int t=0;
            for(int j=0; j<subTotal.length; j++){
                t+= Integer.parseInt(subTotal[j]);
            }
            if(!isExistMinus)
                total=t;
            else
                total-=t;
        }
        System.out.println(total);
    }
}