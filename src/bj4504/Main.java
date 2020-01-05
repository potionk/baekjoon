package bj4504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(br.readLine());
        int input;
        while((input=Integer.parseInt(br.readLine()))!=0){
            System.out.println(input+(isMultiple(input)?" is a multiple of ":" is NOT a multiple of ")+num+".");
        }
    }
    public static boolean isMultiple(int input){
        return input % num == 0;
    }
}