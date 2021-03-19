package bj2531;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int d = Integer.parseInt(info[1]);
        int k = Integer.parseInt(info[2]);
        int c = Integer.parseInt(info[3]);
        int len = N + k - 1;
        int[] sushi = new int[len];
        int[] sushiCount = new int[d + 1];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        System.arraycopy(sushi, 0, sushi, N, len - N);
        int start = 0, end = k - 1, count = 0, result = 0;
        for (int i = start; i <= end; i++) {
            if (sushiCount[sushi[i]] == 0) {
                count++;
            }
            sushiCount[sushi[i]]++;
        }
        result = count + (sushiCount[c] == 0 ? 1 : 0);
        if (N == k) {
            bw.write(result + "");
        } else {
            start++;
            end++;
            while (end < len) {
                sushiCount[sushi[start - 1]]--;
                if (sushiCount[sushi[start - 1]] == 0) {
                    count--;
                }
                start++;
                if (sushiCount[sushi[end]] == 0) {
                    count++;
                }
                sushiCount[sushi[end++]]++;
                result = Math.max(count + (sushiCount[c] == 0 ? 1 : 0), result);
            }
            bw.write(result + "");
        }
        br.close();
        bw.close();
    }
}
