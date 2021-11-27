package bj2491;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int dsMax = 1, isMax = 1, ds = 1, is = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] >= arr[i]) {
                ds++;
            } else {
                ds = 1;
            }
            dsMax = Math.max(ds, dsMax);
            if (arr[i - 1] <= arr[i]) {
                is++;
            } else {
                is = 1;
            }
            isMax = Math.max(is, isMax);
        }
        bw.write(Math.max(isMax, dsMax) + "");
        br.close();
        bw.close();
    }
}