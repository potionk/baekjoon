package bj18408;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int total = Integer.parseInt(tc[0]) + Integer.parseInt(tc[1]) + Integer.parseInt(tc[2]);
        if (total <= 4) {
            bw.write("1");
        } else {
            bw.write("2");
        }
        br.close();
        bw.close();
    }
}
