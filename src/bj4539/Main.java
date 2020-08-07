package bj4539;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            double x = Double.parseDouble(br.readLine());
            int count = 1;
            while (count < x) {
                x = ((int) (Math.round(x / count) * count));
                count *= 10;
            }
            bw.write((int) x + "\n");
        }
        bw.flush();
    }
}