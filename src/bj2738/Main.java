package bj2738;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                bw.write((A[i][j] + Integer.parseInt(readLine[j])) + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
