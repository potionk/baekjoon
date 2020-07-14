package bj5766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] score=new int[1001];
            String[] tc = br.readLine().split(" ");
            int N = Integer.parseInt(tc[0]);
            int M = Integer.parseInt(tc[1]);
            if (N == 0 && M == 0)
                break;
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    int insData = Integer.parseInt(input[j]);
                    score[insData]++;
                }
            }
            int[] checkSecond=new int[1001];
            System.arraycopy(score, 0, checkSecond, 0, score.length);
            Arrays.sort(checkSecond);
            int second=checkSecond[999];
            for(int i=1; i<1001; i++){
                if(score[i]==second)
                    System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
