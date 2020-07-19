package bj11659;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        String[] inputStr = br.readLine().split(" ");
        int[] cumSum = new int[N];
        cumSum[0] = Integer.parseInt(inputStr[0]);
        for (int i = 1; i < N; i++) {
            cumSum[i] = cumSum[i - 1] + Integer.parseInt(inputStr[i]);
        }
        for (int idx = 0; idx < M; idx++) {
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);
            if (i == 1) {
                bw.write(cumSum[j - 1] + "\n");
            } else {
                bw.write(cumSum[j - 1] - cumSum[i - 2] + "\n");
            }
        }
        bw.flush();
    }
}