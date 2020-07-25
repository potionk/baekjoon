package bj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = new String[3];
        for (int i = 0; i < input.length; i++) {
            input[i] = br.readLine();
        }
        int[] count = new int[10];
        int result = Integer.parseInt(input[0]) * Integer.parseInt(input[1]) * Integer.parseInt(input[2]);
        while (result != 0) {
            count[result % 10]++;
            result /= 10;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
    }
}