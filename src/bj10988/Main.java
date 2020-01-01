package bj10988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        System.out.println(isPalindrome(input)?1:0);
    }
    static boolean isPalindrome(String input){
        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i)!=input.charAt(input.length()-i-1))
                return false;
        }
        return true;
    }
}