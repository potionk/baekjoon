package bj3845;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("0 0 0.0")) {
            String[] split = input.split(" ");
            int nx = Integer.parseInt(split[0]);
            int ny = Integer.parseInt(split[1]);
            double w = Double.parseDouble(split[2]);
            String[] xStr = br.readLine().split(" ");
            double[] x = new double[nx];
            for (int i = 0; i < nx; i++) {
                x[i] = Double.parseDouble(xStr[i]);
            }
            String[] yStr = br.readLine().split(" ");
            double[] y = new double[ny];
            for (int i = 0; i < ny; i++) {
                y[i] = Double.parseDouble(yStr[i]);
            }
            Arrays.sort(x);
            Arrays.sort(y);
            boolean fail = false;
            if (x[0] > w / 2 || 75 - x[nx - 1] > w / 2 || y[0] > w / 2 || 100 - y[ny - 1] > w / 2) {
                fail = true;
            }
            for (int i = 0; i < nx - 1; i++) {
                if (x[i + 1] - x[i] > w) {
                    fail = true;
                    break;
                }
            }
            for (int i = 0; i < ny - 1; i++) {
                if (y[i + 1] - y[i] > w) {
                    fail = true;
                    break;
                }
            }
            if (fail) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }
        br.close();
        bw.close();
    }
}