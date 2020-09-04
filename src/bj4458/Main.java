package bj4458;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            String tc = br.readLine();
            if (tc.charAt(0) >= 97) {
                bw.write((char) (tc.charAt(0) - 32) + tc.substring(1) + "\n");
            } else {
                bw.write(tc + "\n");
            }
        }
        bw.flush();
    }
}
