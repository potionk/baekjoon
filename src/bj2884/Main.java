package bj2884;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int hour=Integer.parseInt(input[0]);
        int min=Integer.parseInt(input[1]);
        if(min>=45){
            System.out.println(hour+" "+(min-45));
        }
        else if(hour!=0)
            System.out.println((hour-1)+" "+(15+min));
        else
            System.out.println(23+" "+(15+min));
    }
}