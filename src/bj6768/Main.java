package bj6768;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int j = Integer.parseInt(br.readLine());
        bw.write((j - 1) * (j - 2) * (j - 3) / 6 + "");
        br.close();
        bw.close();
    }
}
