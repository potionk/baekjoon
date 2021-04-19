package bj1972;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String tc = br.readLine();
            if (tc.equals("*")) {
                break;
            }
            if (isSurprisingWord(tc.toCharArray())) {
                bw.write(tc + " is surprising.\n");
            } else {
                bw.write(tc + " is NOT surprising.\n");
            }
        }
        br.close();
        bw.close();
    }

    public static boolean isSurprisingWord(char[] word) {
        int wordLen = word.length;
        Set<String> dupCheck;
        for (int i = 1; i < wordLen; i++) {
            dupCheck = new HashSet<>();
            for (int j = 0; j < wordLen - i; j++) {
                if (dupCheck.contains(word[j] + "" + word[j + i])) {
                    return false;
                }
                dupCheck.add(word[j] + "" + word[j + i]);
            }
        }
        return true;
    }
}
