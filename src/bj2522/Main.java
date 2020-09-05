package bj2522;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            bw.write(makeString(tc - i, ' ') + makeString(i, '*') + "\n");
        }
        for (int i = tc - 1; i > 0; i--) {
            bw.write(makeString(tc - i, ' ') + makeString(i, '*') + "\n");
        }
        bw.flush();
    }

    public static String makeString(int num, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
