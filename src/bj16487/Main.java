package bj16487;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] abc = br.readLine().split(" ");
        double a = Double.parseDouble(abc[0]);
        double b = Double.parseDouble(abc[1]);
        double c = Double.parseDouble(abc[2]);
        double m = Double.parseDouble(br.readLine());
        double n = b - m;
        bw.write(((a * a * n + c * c * m - b * m * n) / b) + "\n");
        bw.flush();
    }
}
