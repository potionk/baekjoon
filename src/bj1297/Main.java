package bj1297;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int d = Integer.parseInt(tc[0]);
        int a = Integer.parseInt(tc[1]);
        int b = Integer.parseInt(tc[2]);
        double rate = d / Math.sqrt(a * a + b * b);
        bw.write((int)Math.floor(a * rate) + " " + (int)Math.floor(b * rate));
        br.close();
        bw.close();
    }
}