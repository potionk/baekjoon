package bj3046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read=br.readLine().split(" ");
        int r1=Integer.parseInt(read[0]);
        int s=Integer.parseInt(read[1]);
        System.out.println(2*s-r1);
    }
}