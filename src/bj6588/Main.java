package bj6588;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 1000000;
        boolean[] primeNum = new boolean[max];
        primeNum[0] = true;
        for (int i = 1; i < max; i++) {
            if (!primeNum[i]) {
                for (int j = (i + 1) * 2 - 1; j < max; j += i + 1) {
                    primeNum[j] = true;
                }
            }
        }
        int tc;
        while ((tc = Integer.parseInt(br.readLine())) != 0) {
            int mid = tc / 2;
            boolean isFind = false;
            for (int a = 3; a <= mid + 1; a += 2) {
                if (!primeNum[a - 1] && !primeNum[tc - a - 1]) {
                    bw.write(tc + " = " + a + " + " + (tc - a) + "\n");
                    isFind = true;
                }
                if (isFind)
                    break;
            }
            if (!isFind)
                System.out.println("Goldbach's conjecture is wrong.");
        }
        bw.flush();
        bw.close();
    }
}