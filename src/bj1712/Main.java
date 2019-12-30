package bj1712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        //input[0] + input[1] x < input[2] x
        //input[0] < ( input[2]-input[1] ) x
        int a=Integer.parseInt(input[0]);
        int b=Integer.parseInt(input[2])-Integer.parseInt(input[1]);
        if(b<=0)
            System.out.println(-1);
        else {
            int result = a / b + 1;
            System.out.println(result);
        }
    }
}