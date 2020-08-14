package bj1059;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String[] luckySetStr = br.readLine().split(" ");
        int[] luckySet = new int[L];
        for (int i = 0; i < L; i++) {
            luckySet[i] = Integer.parseInt(luckySetStr[i]);
        }
        Arrays.sort(luckySet);
        int N = Integer.parseInt(br.readLine());
        int min = 0, max = luckySet[0];
        for (int i = L - 1; i > 0; i--) {
            if (luckySet[i] == N || luckySet[i - 1] == N) {
                System.out.println(0);
                return;
            }
            if (luckySet[i] > N && luckySet[i - 1] < N) {
                max = luckySet[i];
                min = luckySet[i - 1];
            }
        }
        System.out.println((N - min) * (max - N) - 1);
    }
}