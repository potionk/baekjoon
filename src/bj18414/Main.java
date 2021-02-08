package bj18414;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] xlr = br.readLine().split(" ");
        int x = Integer.parseInt(xlr[0]);
        int l = Integer.parseInt(xlr[1]);
        int r = Integer.parseInt(xlr[2]);
        if (x >= r) {
            bw.write(r + "");
        } else if (x <= l) {
            bw.write(l + "");
        } else {
            bw.write(x + "");
        }
        br.close();
        bw.close();
    }
}
