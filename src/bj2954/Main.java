package bj2954;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String encryptionText = br.readLine();
        int len = encryptionText.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(encryptionText.charAt(i));
            if (isVowel(encryptionText.charAt(i))) {
                i += 2;
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static boolean isVowel(char input) {
        return switch (input) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }
}