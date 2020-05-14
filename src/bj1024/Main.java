package bj1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        int N = Integer.parseInt(testCase[0]);
        int L = Integer.parseInt(testCase[1]);
        while ((L % 2 == 0 && N % L != L / 2) || (L % 2 == 1 && N % L != 0)) {
            if (L >= 100) {
                System.out.println(-1);
                return;
            }
            L++;
        }
        int[] result = new int[L + 1];
        if (L % 2 == 0) {
            result[L / 2] = N / L;
            for (int i = L / 2 - 1; i >= 0; i--)
                result[i] = result[i + 1] - 1;
            for (int i = L / 2 + 1; i <= L; i++)
                result[i] = result[i - 1] + 1;
        } else {
            result[L / 2 + 1] = N / L;
            for (int i = L / 2; i >= 0; i--)
                result[i] = result[i + 1] - 1;
            for (int i = L / 2 + 2; i <= L; i++)
                result[i] = result[i - 1] + 1;
        }

        if (result[1] < 0) {
            System.out.println(-1);
        } else {
            for (int i = 1; i < L + 1; i++)
                System.out.print(result[i] + " ");
        }
    }
}