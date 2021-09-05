package bj3028;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] tc = br.readLine().toCharArray();
        int curPoint = 0;
        for (char c : tc) {
            switch (c) {
                case 'A' -> {
                    if (curPoint == 0) {
                        curPoint = 1;
                    } else if (curPoint == 1) {
                        curPoint = 0;
                    }
                }
                case 'B' -> {
                    if (curPoint == 1) {
                        curPoint = 2;
                    } else if (curPoint == 2) {
                        curPoint = 1;
                    }
                }
                case 'C' -> {
                    if (curPoint == 2) {
                        curPoint = 0;
                    } else if (curPoint == 0) {
                        curPoint = 2;
                    }
                }
            }
        }
        bw.write((curPoint + 1) + "");
        br.close();
        bw.close();
    }
}
