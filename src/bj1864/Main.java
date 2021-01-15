package bj1864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            long result = 0;
            int len = input.length();
            for (int i = len - 1, p = 1; i >= 0; i--, p *= 8) {
                result += charToOctopus(input.charAt(i)) * p;
            }
            System.out.println(result);
        }
    }

    public static int charToOctopus(char i) {
        switch (i) {
            case '-':
                return 0;
            case '\\':
                return 1;
            case '(':
                return 2;
            case '@':
                return 3;
            case '?':
                return 4;
            case '>':
                return 5;
            case '&':
                return 6;
            case '%':
                return 7;
            case '/':
                return -1;
        }
        return -2;
    }
}