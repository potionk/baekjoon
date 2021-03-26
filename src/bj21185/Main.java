package bj21185;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 == 1) {
            bw.write("Either");
        } else {
            if ((N / 2) % 2 == 0) {
                bw.write("Even");
            } else {
                bw.write("Odd");
            }
        }
        br.close();
        bw.close();
    }
}
