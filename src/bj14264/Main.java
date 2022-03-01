package bj14264;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double l = Double.parseDouble(br.readLine());
        bw.write((l * l * Math.sqrt(3) / 4) + "");
        br.close();
        bw.close();
    }
}
