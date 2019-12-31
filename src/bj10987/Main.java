package bj10987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int count=0;
        for(int i=0; i<input.length(); i++){
            if(isVowel(input.charAt(i)))
                count++;
        }
        System.out.println(count);
    }
    static boolean isVowel(char input){
        switch (input){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
        }
        return false;
    }
}