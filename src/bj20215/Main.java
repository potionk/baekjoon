package bj20215;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] wh = br.readLine().split(" ");
        double w = Double.parseDouble(wh[0]);
        double h = Double.parseDouble(wh[1]);
        bw.write((w + h - Math.sqrt(w * w + h * h)) + "");
        br.close();
        bw.close();
    }
}
