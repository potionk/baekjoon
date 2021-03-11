package bj2166;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        long[] x = new long[tcNum];
        long[] y = new long[tcNum];
        for (int i = 0; i < tcNum; i++) {
            String[] xy = br.readLine().split(" ");
            x[i] = Integer.parseInt(xy[0]);
            y[i] = Integer.parseInt(xy[1]);
        }
        long result = 0;
        for (int i = 0; i < tcNum - 1; i++) {
            result += x[i] * y[i + 1];
        }
        result += x[tcNum - 1] * y[0];
        for (int i = 0; i < tcNum - 1; i++) {
            result -= x[i + 1] * y[i];
        }
        result -= x[0] * y[tcNum - 1];
        result = Math.abs(result);
        bw.write(String.format("%.1f", (double) result / 2));
        br.close();
        bw.close();
    }
}
