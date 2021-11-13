package bj17388;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] skh = br.readLine().split(" ");
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            int t = Integer.parseInt(skh[i]);
            sum += Integer.parseInt(skh[i]);
            min = Math.min(min, t);
        }
        if (sum >= 100) {
            bw.write("OK");
        } else {
            int idx = 0;
            for (int i = 0; i < 3; i++) {
                if ((min + "").equals(skh[i])) {
                    idx = i;
                    break;
                }
            }
            switch (idx) {
                case 0 -> bw.write("Soongsil");
                case 1 -> bw.write("Korea");
                case 2 -> bw.write("Hanyang");
            }
        }
        br.close();
        bw.close();
    }
}
