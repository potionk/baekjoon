package bj2752;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int[] abc=new int[input.length];
        for(int i=0; i<abc.length; i++){
            abc[i]= Integer.parseInt(input[i]);
        }
        Arrays.sort(abc);
        for(int i=0; i<abc.length; i++){
            System.out.print(abc[i]+" ");
        }

    }
}