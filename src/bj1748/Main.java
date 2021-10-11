package bj1748;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0, stage = 1;
        for (int i = 1; i <= n; i++) {
            switch (i) {
                case 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 -> stage++;
            }
            count += stage;
        }
        bw.write(count + "");
        br.close();
        bw.close();
    }
}