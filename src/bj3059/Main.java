package bj3059;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            boolean[] isExist = new boolean[26];
            int total = 0;
            String tc = br.readLine();
            int len = tc.length();
            for (int j = 0; j < len; j++) {
                isExist[tc.charAt(j) - 65] = true;
            }
            for (int j = 0; j < 26; j++) {
                if (!isExist[j]) {
                    total += j + 65;
                }
            }
            bw.write(total + "\n");
        }
        bw.flush();
    }
}
