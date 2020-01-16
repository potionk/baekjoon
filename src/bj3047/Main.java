package bj3047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr=br.readLine().split(" ");
        int[] input=new int[inputStr.length];
        for(int i=0; i<inputStr.length; i++){
            input[i]= Integer.parseInt(inputStr[i]);
        }
        Arrays.sort(input);
        char[] abc=br.readLine().toCharArray();
        for(int i=0; i<abc.length; i++){
            if(abc[i]=='A')
                System.out.print(input[0]);
            else if(abc[i]=='B')
                System.out.print(input[1]);
            else if(abc[i]=='C')
                System.out.print(input[2]);
            System.out.print(" ");
        }
    }
}