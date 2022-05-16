package bj11478;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int len = S.length();
        int targetLen = len;
        Set<String> dupCheckSet = new HashSet<>();
        while (targetLen > 0) {
            for (int i = 0; i + targetLen <= len; i++) {
                dupCheckSet.add(S.substring(i, i + targetLen));
            }
            targetLen--;
        }
        System.out.println(dupCheckSet.size());
        br.close();
        bw.close();
    }
}
