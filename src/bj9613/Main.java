package bj9613;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] tcStr = br.readLine().split(" ");
            int[] tc = new int[tcStr.length];
            for (int j = 0; j < tc.length; j++) {
                tc[j] = Integer.parseInt(tcStr[j]);
            }
            long total = 0;
            for (int a = 1; a < tc.length; a++) {
                for (int b = a + 1; b < tc.length; b++) {
                    total += euclidean(tc[a], tc[b]);
                }
            }
            bw.write(total + "\n");
        }
        bw.flush();
    }

    public static int euclidean(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return euclidean(b, a % b);
    }
}