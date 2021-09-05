package bj10102;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        char[] score = br.readLine().toCharArray();
        int aScore = 0, bScore = 0;
        for (char c : score) {
            if (c == 'A') {
                aScore++;
            } else {
                bScore++;
            }
        }
        if (aScore > bScore) {
            bw.write("A");
        } else if (aScore == bScore) {
            bw.write("Tie");
        } else {
            bw.write("B");
        }
        br.close();
        bw.close();
    }
}
