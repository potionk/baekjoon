package bj2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int inputInt = Integer.parseInt(input);
        int maxGap = input.length() * 9;
        int i;
        if (!(inputInt < 10)) {
            i = inputInt - maxGap;
        } else {
            i = 0;
        }
        for (; i < inputInt; i++) {
            int compareTarget = i;
            String i2Str = i + "";
            for (int j = 0; j < i2Str.length(); j++) {
                compareTarget += Integer.parseInt(i2Str.charAt(j) + "");
            }
            if (compareTarget == inputInt) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}