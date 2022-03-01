package bj7567;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] tc = br.readLine().toCharArray();
        int height = 10;
        for (int i = 1; i < tc.length; i++) {
            if (tc[i - 1] != tc[i]) {
                height += 10;
            } else {
                height += 5;
            }
        }
        bw.write(height + "");
        br.close();
        bw.close();
    }
}
