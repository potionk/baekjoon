package bj5928;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] dhm = br.readLine().split(" ");
        int D = Integer.parseInt(dhm[0]);
        int H = Integer.parseInt(dhm[1]);
        int M = Integer.parseInt(dhm[2]);
        int diff = dayToMin(D, H, M) - dayToMin(11, 11, 11);
        if (diff < 0) {
            bw.write("-1");
        } else {
            bw.write(diff + "");
        }
        br.close();
        bw.close();
    }

    public static int dayToMin(int D, int H, int M) {
        return M + 60 * H + 24 * 60 * D;
    }
}