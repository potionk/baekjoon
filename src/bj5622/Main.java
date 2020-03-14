package bj5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int total=0;
        for(int i=0; i<input.length(); i++){
            switch(input.charAt(i)){
                case 'A':
                case 'B':
                case 'C':
                    total+=2;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    total+=3;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    total+=4;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    total+=5;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    total+=6;
                    break;
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                    total+=7;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    total+=8;
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    total+=9;
                    break;
            }
            total++;
        }
        System.out.println(total);
    }
}