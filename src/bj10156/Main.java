package bj10156;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        int K = Integer.parseInt(tc[0]);
        int N = Integer.parseInt(tc[1]);
        int M = Integer.parseInt(tc[2]);
        if (K * N > M) {
            System.out.println(K * N - M);
        } else {
            System.out.println(0);
        }
    }
}