package bj15873;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        int a = -1, b = -1;
        if (tc.length() == 2) {
            a = tc.charAt(0) - '0';
            b = tc.charAt(1) - '0';
            System.out.println(a+b);
        } else if (tc.length() == 4) {
            System.out.println(20);
        } else {
            if (tc.substring(0, 2).equals("10")) {
                System.out.println((10 + (tc.charAt(2) - '0')));
            } else {
                System.out.println((10 + (tc.charAt(0) - '0')));
            }
        }
    }
}
