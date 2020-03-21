package bj2740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AStr=br.readLine().split(" ");
        int N= Integer.parseInt(AStr[0]);
        int M= Integer.parseInt(AStr[1]);
        int[][] A=new int[N][M];
        for(int i=0; i<N; i++){
            String[] input=br.readLine().split(" ");
            for(int j=0; j<M; j++){
                A[i][j]= Integer.parseInt(input[j]);
            }
        }
        String[] BStr=br.readLine().split(" ");
        int K= Integer.parseInt(BStr[1]);
        int[][] B=new int[M][K];
        for(int i=0; i<M; i++){
            String[] input=br.readLine().split(" ");
            for(int j=0; j<K; j++){
                B[i][j]= Integer.parseInt(input[j]);
            }
        }
        int[][] result=new int[N][K];
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                for(int k=0; k<M; k++){
                    result[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}