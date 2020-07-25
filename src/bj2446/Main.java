package bj2446;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = testCase * 2 - 1, blank = 0; i > 0; i -= 2, blank++) {
            for (int b = 0; b < blank; b++) {
                bw.write(" ");
            }
            for (int s = 0; s < i; s++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = 3, blank = testCase - 2; i < testCase * 2; i += 2, blank--) {
            for (int b = 0; b < blank; b++) {
                bw.write(" ");
            }
            for (int s = 0; s < i; s++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}