package bj1790;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NK = br.readLine().split(" ");
        int n = Integer.parseInt(NK[0]);
        int k = Integer.parseInt(NK[1]);
        int count = 0, stage = 1;
        boolean find = false;
        for (int i = 1; i <= n; i++) {
            switch (i) {
                case 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000 -> stage++;
            }
            if (count <= k && k <= count + stage) {
                String s = i + "";
                bw.write(s.charAt((k - count - 1) % stage));
                find = true;
                break;
            }
            count += stage;
        }
        if (!find) {
            bw.write("-1");
        }
        br.close();
        bw.close();
    }
}
