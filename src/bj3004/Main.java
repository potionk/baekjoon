package bj3004;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write((((N + 1) / 2 + 1) * (N / 2 + 1)) + "");
        br.close();
        bw.close();
    }
}
