package bj1975;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= N; j++) {
                if (N % j == 0) {
                    int thisN = N;
                    while (thisN % j == 0) {
                        count++;
                        thisN /= j;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}