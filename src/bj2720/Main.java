package bj2720;

import java.io.*;

public class Main {
    static final int[] CHANGE_UNIT = {25, 10, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int cent = Integer.parseInt(br.readLine());
            for (int i = 0; i < 3; i++) {
                bw.write(cent / CHANGE_UNIT[i] + " ");
                cent = cent % CHANGE_UNIT[i];
            }
            bw.write(cent + "\n");
        }
        br.close();
        bw.close();
    }
}
