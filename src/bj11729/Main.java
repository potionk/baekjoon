package bj11729;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count=1;
        for(int i=0; i<input; i++){
            count*=2;
        }
        System.out.println(count-1);
        hanoi("1", "2", "3", input);
    }
    static void hanoi(String a, String b, String c,  int n) {
        if (n == 1) {
            System.out.println(a+ " " +c);
        } else {
            hanoi(a, c, b, n - 1);
            System.out.println(a+ " " +c);
            hanoi(b, a, c, n - 1);
        }
    }
}