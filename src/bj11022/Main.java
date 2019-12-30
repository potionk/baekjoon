package bj11022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine());
        for(int i=0; i<c; i++){
            String input[] = br.readLine().split(" ");
            int a=Integer.parseInt(input[0]);
            int b=Integer.parseInt(input[1]);
            System.out.println("Case #"+(i+1)+": "+a+" + "+b+" = "+(a+b));
        }
    }
}