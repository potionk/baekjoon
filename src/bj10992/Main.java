package bj10992;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            for (int j = 0; j < tc - i - 1; j++) {
                bw.write(" ");
            }
            if (i == 0) {
                bw.write("*");
            } else if (i == tc - 1) {
                for (int j = 0; j < i * 2 + 1; j++) {
                    bw.write("*");
                }
            } else {
                bw.write("*");
                for (int j = 0; j < i * 2 - 1; j++) {
                    bw.write(" ");
                }
                bw.write("*");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
