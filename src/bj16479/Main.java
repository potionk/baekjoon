package bj16479;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        K = K * K;
        String[] d1d2 = br.readLine().split(" ");
        double D1 = Double.parseDouble(d1d2[0]);
        double D2 = Double.parseDouble(d1d2[1]);
        if (D1 == D2) {
            bw.write(K + "\n");
        } else {
            double B = (Math.max(D1, D2) - Math.min(D1, D2)) / 2;
            B = B * B;
            bw.write(K - B + "\n");
        }
        bw.flush();
    }
}
