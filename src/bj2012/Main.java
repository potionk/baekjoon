package bj2012;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] studentRank = new int[n];
        for (int i = 0; i < n; i++) {
            studentRank[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(studentRank);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(studentRank[i] - (i + 1));
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
