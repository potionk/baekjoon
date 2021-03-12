package bj14921;

import java.io.*;
import java.util.Arrays;

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
        Arrays.sort(s);
        int start = 0, end = N - 1, sum = s[start] + s[end];
        while (start < end) {
            int thisSum = s[start] + s[end];
            if (Math.abs(thisSum) < Math.abs(sum)) {
                sum = thisSum;
            }
            if (thisSum < 0) {
                start++;
            } else {
                end--;
            }
        }
        bw.write(sum + "");
        br.close();
        bw.close();
    }
}
