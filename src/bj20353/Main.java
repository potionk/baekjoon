package bj20353;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Math.sqrt(Long.parseLong(br.readLine())) * 4 + "");
        br.close();
        bw.close();
    }
}
