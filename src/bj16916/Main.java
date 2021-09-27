package bj16916;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();
        int TLen = T.length;
        int PLen = P.length;
        int[] pi = new int[PLen];
        for (int i = 1, j = 0; i < PLen; i++) {
            while (j > 0 && P[i] != P[j]) {
                j = pi[j - 1];
            }
            if (P[i] == P[j]) {
                pi[i] = ++j;
            }
        }
        boolean contain = false;
        for (int i = 0, j = 0; i < TLen; i++) {
            while (j > 0 && T[i] != P[j]) {
                j = pi[j - 1];
            }
            if (T[i] == P[j]) {
                if (j == PLen - 1) {
                    contain = true;
                    break;
                } else {
                    j++;
                }
            }
        }
        if (contain) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        br.close();
        bw.close();
    }
}
