package bj10990;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(makeBlank(N - 1) + "*\n");
        for (int i = N - 2, j = 1; i >= 0; i--, j += 2) {
            bw.write(makeBlank(i) + "*" + makeBlank(j) + "*\n");
        }
        br.close();
        bw.close();
    }

    public static String makeBlank(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
