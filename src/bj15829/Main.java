package bj15829;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] r=new long[50];
        long result=0;
        r[0]=1;
        for(int i=1; i<r.length; i++){
            r[i]=(r[i-1]*31)%1234567891;
        }
        br.readLine();
        char[] testCase=br.readLine().toCharArray();
        for(int i=0; i<testCase.length; i++){
            result+=((testCase[i]-96)*r[i])%1234567891;
            result=result%1234567891;
        }
        System.out.println(result);
    }
}