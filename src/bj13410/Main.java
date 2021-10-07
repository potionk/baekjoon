package bj13410;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = Math.max(result, Integer.parseInt(new StringBuilder().append(n * (i + 1)).reverse().toString()));
        }
        bw.write(result + "");
        bw.close();
        br.close();
    }
}
