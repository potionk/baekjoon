package bj15700;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        long n = Long.parseLong(nm[0]);
        long m = Long.parseLong(nm[1]);
        if (((n % 10) * (m % 10)) % 2 == 1) {
            bw.write(((n * m - 1) / 2) + "");
        } else {
            bw.write((n * m / 2) + "");
        }
        br.close();
        bw.close();
    }
}
