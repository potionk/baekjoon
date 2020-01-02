package bj5598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input=br.readLine().toCharArray();
        for(int i=0; i<input.length; i++){
            System.out.print(decode(input[i]));
        }
    }
    public static char decode(char input){
        if(input<=67)
            input=(char)(input+26);
        return (char)(input-3);
    }
}