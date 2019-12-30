package bj1065;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count=0;
        while(input>0){
            if(input<100)
                count++;
            else {
                int a=input/100;
                int b=(input/10)%10;
                int c=(input%100)%10;
                if(((a>b&&b>c)||(a<b&&b<c)||(a==b&&b==c))&&a-b==b-c)
                    count++;
            }
            input--;
        }
        System.out.println(count);
    }
}