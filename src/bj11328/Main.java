package bj11328;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            char[][] alphabet = new char[2][26];
            String[] tc = br.readLine().split(" ");
            if (tc[0].length() != tc[1].length()) {
                bw.write("Impossible\n");
            } else {
                int len = tc[0].length();
                for (int j = 0; j < len; j++) {
                    alphabet[0][tc[0].charAt(j) - 'a']++;
                    alphabet[1][tc[1].charAt(j) - 'a']++;
                }
                boolean isPossible = true;
                for (int j = 0; j < 26; j++) {
                    if (alphabet[0][j] != alphabet[1][j]) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) {
                    bw.write("Possible\n");
                } else {
                    bw.write("Impossible\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}
