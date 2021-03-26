package bj14924;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] STD = br.readLine().split(" ");
        int S = Integer.parseInt(STD[0]);
        int T = Integer.parseInt(STD[1]);
        int D = Integer.parseInt(STD[2]);
        bw.write((D / (S * 2)) * T + "");
        br.close();
        bw.close();
    }
}
