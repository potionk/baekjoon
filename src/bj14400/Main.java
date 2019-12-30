package bj14400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] x=new int[count];
        int[] y=new int[count];
        for(int i=0; i<count; i++){
            String[] input = br.readLine().split(" ");
            x[i]=Integer.parseInt(input[0]);
            y[i]=Integer.parseInt(input[0]);
        }

    }
}