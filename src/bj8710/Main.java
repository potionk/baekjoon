package bj8710;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] kwm = br.readLine().split(" ");
        int k = Integer.parseInt(kwm[0]);
        int w = Integer.parseInt(kwm[1]);
        int m = Integer.parseInt(kwm[2]);
        int result = 0;
        while (k < w) {
            k += m;
            result++;
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
