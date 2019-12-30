package bj10818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int c=sc.nextInt();
        for(int i=0; i<c; i++){
            int input=sc.nextInt();
            if(input>max)
                max=input;
            if(input<min)
                min=input;
        }
        System.out.println(min+" "+max);
    }
}