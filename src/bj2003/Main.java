package bj2003;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] AStr = br.readLine().split(" ");
        int[] A = new int[n + 1];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(AStr[i]);
        }
        int start = 0, end = 0, total = 0, result = 0;
        while (end <= n && start <= end) {
            if (total < m) {
                total += A[end++];
            } else {
                total -= A[start++];
            }
            if (total == m) {
                result++;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
