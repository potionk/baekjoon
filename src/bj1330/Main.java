package bj1330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int a=Integer.parseInt(input[0]);
        int b=Integer.parseInt(input[1]);
        if(a>b)
            System.out.println(">");
        else if(a<b)
            System.out.println("<");
        else
            System.out.println("==");
    }
}