package bj1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input.length == 1 && input[0] == '0') {
                break;
            } else {
                int total = 1 + input.length;
                for (int i = 0; i < input.length; i++) {
                    if (input[i] == '0') {
                        total += 4;
                    } else if (input[i] == '1') {
                        total += 2;
                    } else {
                        total += 3;
                    }
                }
                System.out.println(total);
            }
        }
    }
}
