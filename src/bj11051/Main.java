package bj11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int N= Integer.parseInt(testCase[0]);
        int K= Integer.parseInt(testCase[1]);
        int[][] result=new int[N][N+1];

        result[0][0]=1;
        result[0][1]=1;
        for(int i=1; i<N; i++){
            for(int j=0; j<=i+1; j++){
                if(j-1>=0)
                    result[i][j]=(result[i-1][j-1]+result[i-1][j])%10007;
                else
                    result[i][j]=result[i-1][j];
            }
        }
        System.out.println(result[N-1][K]);
    }
}