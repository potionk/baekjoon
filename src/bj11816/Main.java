package bj11816;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc = br.readLine();
        if (tc.length() > 1 && tc.charAt(0) == '0') {
            if (tc.charAt(1) == 'x') {
                bw.write(Integer.parseInt(tc.substring(2), 16)+"\n");
            } else {
                bw.write(Integer.parseInt(tc.substring(1), 8)+"\n");
            }
        } else {
            bw.write(tc + "\n");
        }
        bw.flush();
    }
}
