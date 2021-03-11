package bj2473;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] sStr = br.readLine().split(" ");
        long[] s = new long[N];
        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(sStr[i]);
        }
        Arrays.sort(s);
        int start, end;
        long resultA = s[0], resultB = s[1], resultC = s[N - 1], total = s[0] + s[1] + s[N - 1];
        for (int i = 0; i < N - 1; i++) {
            start = i + 1;
            end = N - 1;
            while (start < end) {
                long thisTotal = s[i] + s[start] + s[end];
                if (Math.abs(thisTotal) < Math.abs(total)) {
                    total = thisTotal;
                    resultA = s[i];
                    resultB = s[start];
                    resultC = s[end];
                }
                if (thisTotal >= 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        bw.write(resultA + " " + resultB + " " + resultC);
        br.close();
        bw.close();
    }
}
