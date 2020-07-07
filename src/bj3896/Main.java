package bj3896;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 1299730;
        boolean[] primeNum = new boolean[max];
        primeNum[0] = true;
        for (int i = 1; i < max; i++) {
            if (!primeNum[i]) {
                for (int j = (i + 1) * 2 - 1; j < max; j += i + 1) {
                    primeNum[j] = true;
                }
            }
        }
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int input = Integer.parseInt(br.readLine());
            if (!primeNum[input - 1]) {
                bw.write(0 + "\n");
            } else {
                int aIndex = input - 1;
                int dIndex = input - 1;
                while (primeNum[(++aIndex)]) ;
                while (primeNum[(--dIndex)]) ;
                bw.write(aIndex - dIndex + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}