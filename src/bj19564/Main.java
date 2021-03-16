package bj19564;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc = br.readLine();
        int count = 0;
        int tcLen = tc.length();
        int beforeTcIdx = Integer.MAX_VALUE;
        for (int i = 0; i < tcLen; i++) {
            if (tc.charAt(i) - 'a' <= beforeTcIdx) {
                count++;
            }
            beforeTcIdx = tc.charAt(i) - 'a';
        }
        bw.write(count + "");
        br.close();
        bw.close();
    }
}
