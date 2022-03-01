package bj11024;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int total = 0;
            String[] readLine = br.readLine().split(" ");
            for (String s : readLine) {
                total += Integer.parseInt(s);
            }
            bw.write(total + "\n");
        }
        br.close();
        bw.close();
    }
}