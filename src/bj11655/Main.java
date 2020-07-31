package bj11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = br.readLine();
        System.out.println(toROT13(testCase));
    }

    public static String toROT13(String input) {
        char[] before = input.toCharArray();
        char[] after = new char[before.length];
        for (int i = 0; i < before.length; i++) {
            if (before[i] + 13 >= 123 || (before[i] <= 90 && before[i] + 13 >= 91)) {
                after[i] = (char) ((before[i] + 13) - 26);
            } else if (isAlphabet(before[i])) {
                after[i] = (char) ((before[i] + 13));
            } else {
                after[i] = before[i];
            }
        }
        return String.valueOf(after);
    }

    public static boolean isAlphabet(char input) {
        return (input >= 65 && input <= 90) || (input >= 97 && input <= 122);
    }
}