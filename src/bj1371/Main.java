package bj1371;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine;
        int[] alphabet = new int[26];
        while ((readLine = br.readLine()) != null) {
            for (int i = 0; i < readLine.length(); i++) {
                if ((int) (readLine.charAt(i)) < 97)
                    continue;
                alphabet[((int) (readLine.charAt(i))) - 97]++;
            }
        }
        int max = -1;
        for (int value : alphabet) {
            if (value > max)
                max = value;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == max)
                System.out.print(((char) (i + 97)));
        }
    }
}