package bj2467;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] sStr = br.readLine().split(" ");
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(sStr[i]);
        }
        int start = 0, end = N - 1, beforeSum = s[start] + s[end], sum = s[start] + s[end], resultA = s[0], resultB = s[end];
        while (end - start >= 2) {
            int left = beforeSum + s[start + 1] - s[start];
            int right = beforeSum + s[end - 1] - s[end];
            int absLeft = Math.abs(left);
            int absRight = Math.abs(right);
            if (absLeft < absRight) {
                start++;
                beforeSum = left;
                if (absLeft < Math.abs(sum)) {
                    sum = left;
                    resultA = s[start];
                    resultB = s[end];
                }
            } else {
                end--;
                beforeSum = right;
                if (absRight < Math.abs(sum)) {
                    sum = right;
                    resultA = s[start];
                    resultB = s[end];
                }
            }
        }
        bw.write(resultA + " " + resultB);
        br.close();
        bw.close();
    }
}
