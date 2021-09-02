package bj6550;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while ((input = br.readLine()) != null) {
            String[] st = input.split(" ");
            char[] s = st[0].toCharArray();
            char[] t = st[1].toCharArray();
            int sIdx = 0;
            for (char c : t) {
                if (sIdx == s.length) {
                    break;
                }
                if (c == s[sIdx]) {
                    sIdx++;
                }
            }
            if (sIdx == s.length) {
                bw.write("Yes\n");
            } else {
                bw.write("No\n");
            }
        }
        br.close();
        bw.close();
    }
}
