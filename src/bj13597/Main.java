package bj13597;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        if (a == b) {
            bw.write(a + "");
        } else {
            if (a > b) {
                bw.write(a + "");
            } else {
                bw.write(b + "");
            }
        }
        br.close();
        bw.close();
    }
}
