package bj2997;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr=br.readLine().split(" " );
        int[] input=new int[inputStr.length];
        for(int i=0; i<input.length; i++){
            input[i]= Integer.parseInt(inputStr[i]);
        }
        Arrays.sort(input);
        if(input[1]-input[0]==input[2]-input[1])
            System.out.println(input[2]+(input[1]-input[0]));
        else if(input[1]-input[0]>input[2]-input[1])
            System.out.println(input[0]+(input[2]-input[1]));
        else
            System.out.println(input[1]+(input[1]-input[0]));
    }
}