package bj4299;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int sum = Integer.parseInt(tc[0]);
        int gap = Integer.parseInt(tc[1]);
        double a = (sum + gap) / 2.0;
        double b = (sum - gap) / 2.0;
        if (a % 1 != 0 || b % 1 != 0 || b < 0) {
            bw.write("-1");
        } else {
            bw.write((int)a + " " + (int)b);
        }
        br.close();
        bw.close();
    }
}