package bj6236;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        int[] money = new int[N];
        int high = 0, low = -1;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            high += money[i];
            low = Math.max(low, money[i]);
        }
        int result = high;
        int mid = 0;
        while (low - high <= 0) {
            mid = (high + low) / 2;
            int wallet = 0, count = 1;
            for (int i = 0; i < N; i++) {
                wallet += money[i];
                if (wallet > mid) {
                    count++;
                    wallet = money[i];
                }
            }
            if (count > M) {
                low = mid + 1;
            } else {
                if (mid < result) {
                    result = mid;
                }
                high = mid - 1;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
