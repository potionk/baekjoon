package bj1965;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] boxes = strArrToIntArr(br.readLine().split(" "));
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (boxes[i] < boxes[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int max = -1;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }

    public static int[] strArrToIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }
}