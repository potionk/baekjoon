package bj1283;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        Set<Character> shortCut = new HashSet<>();
        while (tcNum-- > 0) {
            String[] tc = br.readLine().split(" ");
            tc = setShortCut(tc, shortCut);
            for (String s : tc) {
                bw.write(s + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static String[] setShortCut(String[] tc, Set<Character> shortCut) {
        for (int i = 0; i < tc.length; i++) {
            if (!shortCut.contains(toLowerCase(tc[i].charAt(0)))) {
                shortCut.add(toLowerCase(tc[i].charAt(0)));
                tc[i] = "[" + tc[i].charAt(0) + "]" + tc[i].substring(1);
                return tc;
            }
        }
        for (int i = 0; i < tc.length; i++) {
            for (int j = 0; j < tc[i].length(); j++) {
                if (!shortCut.contains(toLowerCase(tc[i].charAt(j)))) {
                    shortCut.add(toLowerCase(tc[i].charAt(j)));
                    tc[i] = tc[i].substring(0, j) + "[" + tc[i].charAt(j) + "]" + (j != tc[i].length() - 1 ? tc[i].substring(j + 1) : "");
                    return tc;
                }
            }
        }
        return tc;
    }

    public static char toLowerCase(char c) {
        if (97 <= c && c <= 122) {
            return c;
        } else {
            return (char) (c + 32);
        }
    }
}
