package bj2805;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        String[] woodArrStr = br.readLine().split(" ");
        long[] woodArr = new long[N];
        for (int i = 0; i < N; i++) {
            woodArr[i] = Long.parseLong(woodArrStr[i]);
        }
        long low = 1, result = 0;
        long high = woodArr[0];
        for (long w : woodArr) {
            high = Math.max(high, w);
        }
        while (low <= high) {
            long mid = (high + low) / 2;
            long total = 0;
            for (long w : woodArr) {
                if (w > mid) {
                    total += w - mid;
                }
            }
            if (total == M) {
                result = mid;
                break;
            } else if (total > M) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
