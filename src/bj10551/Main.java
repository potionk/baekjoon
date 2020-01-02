package bj10551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] checkFinger=new int[8];
        String readline=br.readLine();
        for(int i=0; i<readline.length(); i++){
            checkFinger[findFinger(readline.charAt(i))]++;
        }
        for(int i=0; i<checkFinger.length; i++){
            System.out.println(checkFinger[i]);
        }
    }
    static int findFinger(char input){
        switch (input){
            case '1': case 'Q': case 'A': case 'Z':
                return 0;
            case '2': case 'W': case 'S': case 'X':
                return 1;
            case '3': case 'E': case 'D': case 'C':
                return 2;
            case '4': case 'R': case 'F': case 'V':
            case '5': case 'T': case 'G': case 'B':
                return 3;
            case '6': case 'Y': case 'H': case 'N':
            case '7': case 'U': case 'J': case 'M':
                return 4;
            case '8': case 'I': case 'K': case ',':
                return 5;
            case '9': case 'O': case 'L': case '.':
                return 6;
            case '0': case 'P': case ';': case '/':
            case '-': case '[': case ']': case '\'':
            case '=':
                return 7;
        }
        return -1;
    }
}