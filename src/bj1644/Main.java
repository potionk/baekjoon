package bj1644;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] primeNum = new boolean[N];
        primeNum[0] = true;
        int count = 0;
        for (int i = 1; i < N; i++) {
            if (!primeNum[i]) {
                for (int j = (i + 1) * 2 - 1; j < N; j += i + 1) {
                    if (!primeNum[j]) {
                        primeNum[j] = true;
                        count++;
                    }
                }
            }
        }
        int primeNumLength = N - count - 1;
        int[] primeNumArr = new int[primeNumLength + 1];
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (!primeNum[i]) {
                primeNumArr[idx++] = i + 1;
            }
        }
        int start = 0, end = 0, total = 0, result = 0;
        while (end <= primeNumLength && start <= end) {
            if (total < N) {
                total += primeNumArr[end++];
            } else {
                total -= primeNumArr[start++];
            }
            if (total == N) {
                result++;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
