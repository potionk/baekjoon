package bj9237;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] tStr = br.readLine().split(" ");
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(tStr[i]);
        }
        Arrays.sort(t);
        int result = -1;
        for (int i = n - 1, d = 1; i >= 0; i--, d++) {
            result = Math.max(result, t[i] + d);
        }
        bw.write((result + 1) + "");
        br.close();
        bw.close();
    }
}
