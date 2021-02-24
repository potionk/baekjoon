package bj19698;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int W = Integer.parseInt(tc[1]);
        int H = Integer.parseInt(tc[2]);
        int L = Integer.parseInt(tc[3]);
        int max = (int) Math.floor(((W / L) * (H / L)));
        if (N < max) {
            max = N;
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }
}
