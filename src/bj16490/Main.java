package bj16490;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        long a = Long.parseLong(tc[0]);
        long b = Long.parseLong(tc[1]);
        bw.write((a * a - b * b) + "\n");
        bw.flush();
    }
}
