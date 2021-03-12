package bj2230;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        int start = 0, end = 0, diff = Integer.MAX_VALUE;
        while (end < N && start <= end) {
            int thisDiff = A[end] - A[start];
            if (thisDiff >= M && thisDiff < diff) {
                diff = thisDiff;
            }
            if (thisDiff >= M) {
                start++;
            } else {
                end++;
            }
        }
        bw.write(diff + "");
        br.close();
        bw.close();
    }
}
