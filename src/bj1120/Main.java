package bj1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase= br.readLine().split(" ");
        String X=testCase[0];
        String Y=testCase[1];
        int xLen=X.length();
        int yLen=Y.length();
        int num=yLen-xLen;
        int result= Integer.MAX_VALUE;
        for(int i=0; i<=num; i++){
            int diff=0;
            for(int j=0; j<xLen; j++){
                if(X.charAt(j)!=Y.charAt(i+j))
                    diff++;
            }
            result=Math.min(result, diff);
        }
        System.out.println(result);
    }
}
