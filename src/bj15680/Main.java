package bj15680;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        if (input == 0) {
            bw.write("YONSEI");
        } else {
            bw.write("Leading the Way to the Future");
        }
        bw.flush();
    }
}