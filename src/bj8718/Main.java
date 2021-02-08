package bj8718;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] xk = br.readLine().split(" ");
        int x = Integer.parseInt(xk[0]); //total
        int k = Integer.parseInt(xk[1]);
        if (7 * k <= x) {
            bw.write(7 * 1000 * k + "");
        } else if (7 * k <= 2 * x) {
            bw.write(7 * 1000 / 2 * k + "");
        } else if (7 * k <= 4 * x) {
            bw.write(7 * 1000 / 4 * k + "");
        } else {
            bw.write("0");
        }
        br.close();
        bw.close();
    }
}