package bj1037;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.IOException;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] inputStr=br.readLine().split(" ");
        int[] input=new int[inputStr.length];
        for(int i=0; i<input.length; i++){
            input[i]= Integer.parseInt(inputStr[i]);
        }
        Arrays.sort(input);
        System.out.println(input[0]*input[input.length-1]);
    }
}