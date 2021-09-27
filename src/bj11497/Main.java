package bj11497;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] logStrArr = br.readLine().split(" ");
            int[] logArr = new int[n];
            for (int i = 0; i < n; i++) {
                logArr[i] = Integer.parseInt(logStrArr[i]);
            }
            int[] arr = new int[n];
            Arrays.sort(logArr);
            for (int i = 0, start = 0, end = n - 1; i < n; i += 2, start++, end--) {
                arr[start] = logArr[i];
                if (i + 1 != n) {
                    arr[end] = logArr[i + 1];
                }
            }
            int result = Math.abs(arr[0] - arr[n - 1]);
            for (int i = 0; i < n - 1; i++) {
                result = Math.max(result, Math.abs(arr[i] - arr[i + 1]));
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
