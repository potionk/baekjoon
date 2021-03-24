package bj1264;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String readline;
        int count;
        while (!(readline = br.readLine()).equals("#")) {
            count = 0;
            int len = readline.length();
            for (int i = 0; i < len; i++) {
                if (isVowel(readline.charAt(i))) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        br.close();
        bw.close();
    }

    public static boolean isVowel(char input) {
        return switch (input) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }
}
