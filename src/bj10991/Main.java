package bj10991;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            for (int j = 0; j < tc - i; j++) {
                bw.write(" ");
            }
            for (int j = 0; j < i; j++) {
                bw.write("* ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}