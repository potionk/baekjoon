package bj15474;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int A = Integer.parseInt(tc[1]);
        int B = Integer.parseInt(tc[2]);
        int C = Integer.parseInt(tc[3]);
        int D = Integer.parseInt(tc[4]);
        int needA = (int) (Math.ceil((double) N / A));
        int needB = (int) (Math.ceil((double) N / C));
        System.out.println(Math.min(needA * B, needB * D));
    }
}