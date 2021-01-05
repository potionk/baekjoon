package bj1718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] target = br.readLine().toCharArray();
        char[] key = br.readLine().toCharArray();
        for (int i = 0; i < target.length; i++) {
            if (target[i] != ' ') {
                target[i] = (char) ((target[i] - key[i % key.length] + 25) % 26 + 97);
            }
        }
        for (char c : target) {
            System.out.print(c);
        }
    }
}
