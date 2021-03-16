package bj13419;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String input = br.readLine();
            int len = input.length();
            if (len % 2 == 1) {
                input += input;
                len *= 2;
            }
            StringBuilder aSb = new StringBuilder();
            StringBuilder bSb = new StringBuilder();
            for (int i = 0; i < len; i += 2) {
                aSb.append(input.charAt(i));
                bSb.append(input.charAt(i + 1));
            }
            bw.write(aSb + "\n" + bSb + "\n");
        }
        br.close();
        bw.close();
    }
}
