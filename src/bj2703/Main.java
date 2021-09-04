package bj2703;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] encrypted = br.readLine().toCharArray();
            char[] key = br.readLine().toCharArray();
            for (int i = 0; i < encrypted.length; i++) {
                if (encrypted[i] != ' ') {
                    encrypted[i] = key[encrypted[i] - 'A'];
                }
            }
            bw.write(new String(encrypted) + "\n");
        }
        br.close();
        bw.close();
    }
}
