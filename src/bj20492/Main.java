package bj20492;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write((int) (N * 0.78) + " " + (int)((N * 0.8) + (N * 0.2 * 0.78)));
        br.close();
        bw.close();
    }
}
