package bj2559;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] temperatureStr = br.readLine().split(" ");
        int[] temperature = new int[N];
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(temperatureStr[i]);
        }
        int start = 0, end = N, total = 0;
        for (int i = start; i < K; i++) {
            total += temperature[i];
        }
        int max = total;
        for (int i = 0; i < end - K; i++) {
            total -= temperature[i];
            total += temperature[i + K];
            max = Math.max(max, total);
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }
}