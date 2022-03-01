package bj1786;

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
        int resultCount = 0;
        List<Integer> resultIdxList = new LinkedList<>();
        for (int i = 0, j = 0; i < TLen; i++) {
            while (j > 0 && T[i] != P[j]) {
                j = pi[j - 1];
            }
            if (T[i] == P[j]) {
                if (j == PLen - 1) {
                    resultCount++;
                    resultIdxList.add(i - PLen + 2);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        bw.write(resultCount + "\n");
        for (int idx : resultIdxList) {
            bw.write(idx + " ");
        }
        br.close();
        bw.close();
    }
}
