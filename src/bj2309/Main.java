package bj2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input=new int[9];
        int total=0;
        int target,findA=0,findB=0;
        for(int i=0; i<9; i++){
            input[i]=Integer.parseInt(br.readLine());
            total+=input[i];
        }
        target=total-100;
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(input[i]+input[j]==target){
                    findA=i;
                    findB=j;
                    break;
                }
            }
        }
        input[findA]=0;
        input[findB]=0;
        Arrays.sort(input);
        for(int i=2; i<9; i++){
            System.out.println(input[i]);
        }
    }
}
