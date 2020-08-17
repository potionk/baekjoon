package bj3460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            String input2bin = Integer.toBinaryString(input);
            int len = input2bin.length();
            for (int j = 0; j < len; j++) {
                if (input2bin.charAt(input2bin.length() - j - 1) == '1') {
                    System.out.print(j + " ");
                }
            }
        }
    }
}