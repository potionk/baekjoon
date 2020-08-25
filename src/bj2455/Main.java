package bj2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            num -= Integer.parseInt(input[0]);
            num += Integer.parseInt(input[1]);
            max = Math.max(num, max);
        }
        System.out.println(max);
    }
}