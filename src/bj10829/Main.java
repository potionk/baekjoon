package bj10829;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());
        StringBuilder binaryStr = new StringBuilder();
        while (N > 0) {
            binaryStr.insert(0, N % 2);
            N /= 2;
        }
        bw.write(binaryStr.toString());
        br.close();
        bw.close();
    }
}
