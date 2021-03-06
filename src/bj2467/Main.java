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
        int start = 0, end = N - 1, sum = s[start] + s[end], resultA = s[0], resultB = s[end];
        while (start < end) {
            int thisSum = s[start] + s[end];
            if (Math.abs(thisSum) < Math.abs(sum)) {
                sum = thisSum;
                resultA = s[start];
                resultB = s[end];
            }
            if (thisSum < 0) {
                start++;
            } else {
                end--;
            }
        }
        bw.write(resultA + " " + resultB);
        br.close();
        bw.close();
    }
}
