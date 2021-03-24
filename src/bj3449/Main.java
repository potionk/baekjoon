package bj3449;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String a = br.readLine();
            String b = br.readLine();
            int len = a.length();
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                }
            }
            bw.write("Hamming distance is " + count + ".\n");
        }
        br.close();
        bw.close();
    }
}
