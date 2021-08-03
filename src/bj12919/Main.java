package bj12919;

import java.io.*;

public class Main {
    static boolean isFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String T = br.readLine();
        dfs(S, T, S.length(), T.length());
        if (isFind) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
        bw.close();
    }

    public static void dfs(String s, String t, int sLen, int tLen) {
        if (!isFind) {
            if (sLen == tLen) {
                if (s.equals(t)) {
                    isFind = true;
                }
            } else {
                if (t.charAt(0) == 'B') {
                    dfs(s, reverseStr(t.substring(1)), sLen, tLen - 1);
                }
                if (t.charAt(tLen - 1) == 'A') {
                    dfs(s, t.substring(0, tLen - 1), sLen, tLen - 1);
                }
            }
        }
    }

    public static String reverseStr(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}