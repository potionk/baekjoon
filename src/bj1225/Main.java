package bj1225;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        long aTotal = 0;
        long bTotal = 0;
        int aLen = tc[0].length(), bLen = tc[1].length();
        for (int i = 0; i < aLen; i++) {
            aTotal += tc[0].charAt(i) - '0';
        }
        for (int i = 0; i < bLen; i++) {
            bTotal += tc[1].charAt(i) - '0';
        }
        bw.write(aTotal * bTotal + "\n");
        bw.flush();
    }
}
