package bj2018;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            bw.write("1");
        } else {
            int start = 1;
            int end = 2;
            int total = 3;
            int count = 0;
            while (end <= n && start < end) {
                if (total < n) {
                    end++;
                    total += end;
                } else {
                    total -= start;
                    start++;
                }
                if (total == n) {
                    count++;
                }
            }
            bw.write((count + 1) + "");
        }
        br.close();
        bw.close();
    }
}
