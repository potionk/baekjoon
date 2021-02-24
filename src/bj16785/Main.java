package bj16785;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int A = Integer.parseInt(tc[0]);
        int B = Integer.parseInt(tc[1]);
        int C = Integer.parseInt(tc[2]);
        int days = 0;
        int coins = 0;
        while (coins < C) {
            coins += A;
            days++;
            if (days % 7 == 0) {
                coins += B;
            }
        }
        bw.write(days + "");
        br.close();
        bw.close();
    }
}
