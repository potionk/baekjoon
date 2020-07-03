package bj10539;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] arr=br.readLine().split(" ");
        int[] B=new int[arr.length];
        int[] A=new int[arr.length];
        for(int i=0; i<arr.length; i++)
            B[i]= Integer.parseInt(arr[i]);
        A[0]=B[0];
        for(int i=1; i<B.length; i++){
            A[i]=B[i]*(i+1)-B[i-1]*i;
        }
        for(int i=0; i<B.length; i++)
            System.out.print(A[i]+" ");
    }
}