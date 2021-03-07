package bj6778;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int antenna = Integer.parseInt(br.readLine());
        int eyes = Integer.parseInt(br.readLine());
        if (antenna >= 3 && eyes <= 4) {
            bw.write("TroyMartian\n");
        }
        if (antenna <= 6 && eyes >= 2) {
            bw.write("VladSaturnian\n");
        }
        if (antenna <= 2 && eyes <= 3) {
            bw.write("GraemeMercurian\n");
        }
        br.close();
        bw.close();
    }
}
