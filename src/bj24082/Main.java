package bj24082;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((int) Math.pow(Integer.parseInt(br.readLine()), 3) + "");
        br.close();
        bw.close();
    }
}
