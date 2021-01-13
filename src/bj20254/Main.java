package bj20254;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        bw.write((Integer.parseInt(tc[0]) * 56 + Integer.parseInt(tc[1]) * 24 + Integer.parseInt(tc[2]) * 14 + Integer.parseInt(tc[3])* 6 ) + "");
        br.close();
        bw.close();
    }
}
