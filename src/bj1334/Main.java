package bj1334;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        if(input.length()<10){
            long inputI=Long.parseLong(input);
            while(!isPalindrome(inputI+"")) {
                inputI++;
            }
            System.out.println(inputI);
        }
        else if(input.length()<19){
            long inputL=Long.parseLong(input);
            while(!isPalindrome(inputL+"")) {
                inputL++;
            }
            System.out.println(inputL);
        }
        else {

            BigInteger inputB=new BigInteger(input);
            while(!isPalindrome(inputB+"")) {
                inputB=inputB.add(BigInteger.ONE);
            }
            System.out.println(inputB);
        }
    }
    static boolean isPalindrome(String input){
        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i)!=input.charAt(input.length()-i-1))
                return false;
        }
        return true;
    }
}