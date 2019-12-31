package bj2789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if(!isCensorTarget(input.charAt(i)))
                sb.append(input.charAt(i)+"");
        }
        System.out.println(sb.toString());
    }

    static boolean isCensorTarget(char input){
        switch (input){
            case 'C':
            case 'A':
            case 'M':
            case 'B':
            case 'R':
            case 'I':
            case 'D':
            case 'G':
            case 'E':
                return true;
        }
        return false;
    }
}