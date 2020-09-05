package bj16482;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] abc = br.readLine().split(" ");
        double a = Double.parseDouble(abc[0]);
        double b = Double.parseDouble(abc[1]);
        double c = Double.parseDouble(abc[2]);
        String[] AF_BD = br.readLine().split(" ");
        double AF = Double.parseDouble(AF_BD[0]);
        double BD = Double.parseDouble(AF_BD[1]);
        double BF = c - AF;
        double CD = a - BD;
        double K = BF * CD / AF / BD;
        bw.write((K * b) / (1 + K) + "\n");
        bw.flush();
    }
}
