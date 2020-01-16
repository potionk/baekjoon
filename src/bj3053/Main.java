package bj3053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double testCase= Integer.parseInt(br.readLine());
        System.out.println(String.format("%.6f",testCase*testCase*Math.PI));
        System.out.println(String.format("%.6f",testCase*testCase*2));
    }
}