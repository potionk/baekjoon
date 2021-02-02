package bj8741;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        bw.write("1".repeat(k) + "0".repeat(k - 1)); // 2^(2k-1)-2^(k-1)
        br.close();
        bw.close();
    }
}
