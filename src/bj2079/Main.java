package bj2079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input=br.readLine().toCharArray();
        int count=0;
        for(int i=0; i<input.length;){
            int max=1;
            for(int j=i; j<input.length; j++){
                if(isPalindrome(i, j+1))
                    max=j-i+1;
            }
            i+=max;
            count++;
        }
        System.out.println(count);
    }
    static boolean isPalindrome(int startIndex, int finishIndex) {
        int length=startIndex+(finishIndex-startIndex+1)/2;
        for (int i = startIndex; i < length; i++) {
            if (input[i] != input[finishIndex - (i-startIndex) - 1])
                return false;
        }
        return true;
    }
}

/*
anavolimilana
 */