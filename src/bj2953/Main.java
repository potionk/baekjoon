package bj2953;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] score=new int[5];
        for(int i=0; i<5; i++){
            String[] readScore=br.readLine().split(" ");
            int total=0;
            for(int j=0; j<4; j++){
                total += Integer.parseInt(readScore[j]);
            }
            score[i]=total;
        }
        int max=-1, maxIndex=-1;
        for(int i=0; i<5; i++){
            if(score[i]>max){
                max=score[i];
                maxIndex=i;
            }
        }
        System.out.println(maxIndex+1+" "+max);
    }
}