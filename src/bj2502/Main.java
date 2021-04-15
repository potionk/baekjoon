package bj2502;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] DK = br.readLine().split(" ");
        int D = Integer.parseInt(DK[0]);
        int K = Integer.parseInt(DK[1]);
        int[] aDp = new int[D];
        int[] bDp = new int[D];
        aDp[0] = 1;
        aDp[1] = 0;
        bDp[0] = 0;
        bDp[1] = 1;
        for (int i = 2; i < D; i++) {
            aDp[i] = aDp[i - 2] + aDp[i - 1];
            bDp[i] = bDp[i - 2] + bDp[i - 1];
        }
        int max = K / bDp[D - 1];
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= i; j++) {
                if (bDp[D - 1] * i + aDp[D - 1] * j == K) {
                    bw.write(j + "\n" + i);
                    br.close();
                    bw.close();
                    return;
                }
            }
        }
    }
}
