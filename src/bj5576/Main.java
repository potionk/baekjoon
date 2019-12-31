package bj5576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] wUniv=new int[10];
        int[] kUniv=new int[10];
        for(int i=0; i<10; i++){
            wUniv[i]+=Integer.parseInt(br.readLine());
        }
        for(int i=0; i<10; i++){
            kUniv[i]+=Integer.parseInt(br.readLine());
        }
        Arrays.sort(wUniv);
        Arrays.sort(kUniv);
        int wScore=wUniv[9]+wUniv[8]+wUniv[7];
        int kScore=kUniv[9]+kUniv[8]+kUniv[7];
        System.out.println(wScore+" "+kScore);
    }
}