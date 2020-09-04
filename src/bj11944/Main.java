package bj11944;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        for (int i = 0; i < N; i++) {
            sb.append(N);
        }
        String result = sb.toString();
        if (result.length() <= M) {
            bw.write(result);
        } else {
            bw.write(result.substring(0, M));
        }
        bw.flush();
    }
}
