package bj20944;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("a".repeat(Integer.parseInt(br.readLine())));
        br.close();
        bw.close();
    }
}
