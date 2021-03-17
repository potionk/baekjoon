package bj13422;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] NMK = br.readLine().split(" ");
            int N = Integer.parseInt(NMK[0]);
            int M = Integer.parseInt(NMK[1]);
            long K = Long.parseLong(NMK[2]);
            String[] moneyInHouseStr = br.readLine().split(" ");
            int len = N + M - 1;
            long[] moneyInHouse = new long[len];
            for (int i = 0; i < N; i++) {
                moneyInHouse[i] = Integer.parseInt(moneyInHouseStr[i]);
            }
            if (moneyInHouse.length - N >= 0) {
                System.arraycopy(moneyInHouse, 0, moneyInHouse, N, len - N);
            }
            int start = 0, end = M;
            long total = 0, result = 0;
            for (int i = 0; i < M; i++) {
                total += moneyInHouse[i];
            }
            if (total < K && N == M) {
                bw.write("1\n");
                continue;
            }
            if (total < K) {
                result++;
            }
            while (end < len) {
                total -= moneyInHouse[start++];
                total += moneyInHouse[end++];
                if (total < K) {
                    result++;
                }
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
