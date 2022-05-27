package bj2592;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] count = new int[100];
        int total = 0;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            total += n;
            count[(n / 10) - 1]++;
        }
        int maxCount = 0;
        int mode = 0;
        for (int i = 0; i < 100; i++) {
            if (count[i] > maxCount) {
                mode = i;
                maxCount = count[i];
            }
        }
        bw.write(total / 10 + "\n" + (mode + 1) * 10);
        br.close();
        bw.close();
    }
}
