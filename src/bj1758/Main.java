package bj1758;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long result = 0;
        int[] tips = new int[n];
        for (int i = 1; i <= n; i++) {
            tips[i - 1] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips);
        for (int i = 1; i <= n; i++) {
            int tip = tips[n - i];
            if (tip - (i - 1) > 0) {
                result += tip - (i - 1);
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
