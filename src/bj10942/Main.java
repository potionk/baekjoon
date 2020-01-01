package bj10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        input=br.readLine().split(" ");
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            String[] question=br.readLine().split(" ");
            String toString=makeString(Integer.parseInt(question[0]),Integer.parseInt(question[1]));
            System.out.println(isPalindrome(toString)?1:0);
        }
    }
    static String makeString(int startIndex, int finishIndex){
        StringBuilder sb=new StringBuilder();
        for(int i=startIndex-1; i<finishIndex; i++){
            sb.append(input[i]);
        }
        return sb.toString();
    }
    static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1))
                return false;
        }
        return true;
    }
}