package bj10872;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println(factorial(input));
    }
    static int factorial(int input){
        if(input==1||input==0){
            return 1;
        }
        else{
            return input*factorial(input-1);
        }
    }
}
