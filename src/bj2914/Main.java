package bj2914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] read=br.readLine().split(" ");
        int a=Integer.parseInt(read[0]);
        int i=Integer.parseInt(read[1]);
        System.out.println((a*(i-1))+1);
    }
}