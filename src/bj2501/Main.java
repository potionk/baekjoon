package bj2501;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int K = Integer.parseInt(tc[1]);
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
            if (count == K) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}