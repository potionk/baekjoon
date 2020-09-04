package bj2810;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String input = br.readLine();
        int sCount = 0, lCount = 0;
        int len = input.length();
        for (int i = 0; i < len; i++) {
            if (input.charAt(i) == 'S') {
                sCount++;
            } else {
                lCount++;
            }
        }
        if (lCount == 0) {
            bw.write(sCount + "\n");
        } else {
            bw.write(sCount + lCount / 2 + 1 + "\n");
        }
        bw.flush();
    }
}
