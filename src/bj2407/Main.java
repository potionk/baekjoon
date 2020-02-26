package bj2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int N= Integer.parseInt(testCase[0]);
        int K= Integer.parseInt(testCase[1]);
        BigInteger[][] result=new BigInteger[N][N+1];
        for(int i=0; i<N; i++){
            for(int j=0; j<N+1; j++){
                result[i][j]=BigInteger.ZERO;
            }
        }
        result[0][0]=BigInteger.valueOf(1);
        result[0][1]=BigInteger.valueOf(1);
        for(int i=1; i<N; i++){
            for(int j=0; j<=i+1; j++){
                if(j-1>=0)
                    result[i][j]=result[i-1][j-1].add(result[i-1][j]);
                else
                    result[i][j]=result[i-1][j];
            }
        }
        System.out.println(result[N-1][K]);
    }
}