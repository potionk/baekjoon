package bj11758;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] x = new long[3];
        long[] y = new long[3];
        for (int i = 0; i < 3; i++) {
            String[] xy = br.readLine().split(" ");
            x[i] = Integer.parseInt(xy[0]);
            y[i] = Integer.parseInt(xy[1]);
        }
        long result = 0;
        for (int i = 0; i < 3 - 1; i++) {
            result += x[i] * y[i + 1];
            result -= x[i + 1] * y[i];
        }
        result += x[3 - 1] * y[0];
        result -= x[0] * y[3 - 1];
        if (result == 0) {
            bw.write("0");
        } else if (result > 0) {
            bw.write("1");
        } else {
            bw.write("-1");
        }
        br.close();
        bw.close();
    }
}
