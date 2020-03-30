package bj17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int resultCount=Integer.MAX_VALUE;
        for(int i=(int)Math.sqrt(testCase); i>(int)Math.sqrt(testCase)/2; i--){
            int tc1=testCase;
            tc1-=i*i;
            if(tc1==0){
                resultCount=1;
                break;
            }
            for(int j=(int)Math.sqrt(tc1); j>(int)Math.sqrt(tc1)/2; j--){
                int tc2=tc1;
                tc2-=j*j;
                if(tc2==0){
                    resultCount=Math.min(resultCount, 2);
                    break;
                } else if(tc2<0)
                    break;
                for(int k=(int)Math.sqrt(tc2); k>(int)Math.sqrt(tc2)/2; k--){
                    int tc3=tc2;
                    tc3-=k*k;
                    if(tc3==0){
                        resultCount=Math.min(resultCount, 3);
                        break;
                    } else if(tc3<0)
                        break;
                    int l=(int)Math.sqrt(tc3);
                    tc3-=l*l;
                    if(tc3==0){
                        resultCount=Math.min(resultCount, 4);
                    }
                }
            }
        }
        System.out.println(resultCount);
    }
}