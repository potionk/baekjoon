package bj10174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        String input;
        for(int i=0; i<count; i++){
            input=br.readLine();
            System.out.println(isPalindrome(input)?"Yes":"No");
        }
    }
    static boolean isPalindrome(String input){
        input=input.toLowerCase();
        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i)!=input.charAt(input.length()-i-1))
                return false;
        }
        return true;
    }
}