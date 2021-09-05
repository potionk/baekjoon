package bj2744;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] tc = br.readLine().toCharArray();
        for (int i = 0; i < tc.length; i++) {
            if ('a' <= tc[i] && tc[i] <= 'z') {
                tc[i] -= 32;
            } else {
                tc[i] += 32;
            }
        }
        bw.write(new String(tc));
        br.close();
        bw.close();
    }
}
