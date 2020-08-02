package bj1357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        System.out.println(reverse((reverse(testCase[0]) + reverse(testCase[1])) + ""));
    }

    public static int reverse(String input) {
        StringBuilder sb = new StringBuilder();
        int size = input.length();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}
