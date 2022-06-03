package bj15969;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] score = br.readLine().split(" ");
        for (String s : score) {
            int scoreInt = Integer.parseInt(s);
            min = Math.min(min, scoreInt);
            max = Math.max(max, scoreInt);
        }
        bw.write(max - min + "");
        br.close();
        bw.close();
    }
}
