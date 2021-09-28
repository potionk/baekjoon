package bj2212;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        String[] sensorStrArr = br.readLine().split(" ");
        int[] sensorArr = new int[N];
        int[] gapArr = new int[N - 1];
        for (int i = 0; i < N; i++) {
            sensorArr[i] = Integer.parseInt(sensorStrArr[i]);
        }
        Arrays.sort(sensorArr);
        for (int i = 0; i < N - 1; i++) {
            gapArr[i] = sensorArr[i + 1] - sensorArr[i];
        }
        Arrays.sort(gapArr);
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += gapArr[i];
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
