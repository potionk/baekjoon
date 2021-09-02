package bj2745;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NB = br.readLine().split(" ");
        char[] N = NB[0].toCharArray();
        int B = Integer.parseInt(NB[1]);
        int total = 0;
        for (int i = N.length - 1, ns = 1; i >= 0; i--, ns *= B) {
            if (isNum(N[i])) {
                total += (N[i] - '0') * ns;
            } else {
                total += (N[i] - 'A' + 10) * ns;
            }
        }
        bw.write(total + "");
        br.close();
        bw.close();
    }

    public static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }
}
