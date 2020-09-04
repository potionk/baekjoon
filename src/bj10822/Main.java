package bj10822;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(",");
        int total = 0;
        for (String s : tc) {
            total += Integer.parseInt(s);
        }
        bw.write(total + "");
        bw.flush();
    }
}
