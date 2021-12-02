package bj18005;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            bw.write("0");
        } else {
            n /= 2;
            if (n % 2 == 1) {
                bw.write("1");
            } else {
                bw.write("2");
            }
        }
        br.close();
        bw.close();
    }
}
