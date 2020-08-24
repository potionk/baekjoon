package bj1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        tc = tc.trim();
        int tcLen = tc.length();
        if (tcLen == 0) {
            System.out.println(0);
            return;
        }
        int count = 1;
        for (int i = 0; i < tcLen; i++) {
            if (tc.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(count);
    }
}