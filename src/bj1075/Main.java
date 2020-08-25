package bj1075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        N -= N % 100;
        int F = Integer.parseInt(br.readLine());
        for (int i = 0; i < 100; i++) {
            if ((N + i) % F == 0) {
                System.out.println(unifyFormat(i));
                break;
            }
        }
    }

    public static String unifyFormat(int input) {
        if (input < 10) {
            return "0" + input;
        } else {
            return input + "";
        }
    }
}