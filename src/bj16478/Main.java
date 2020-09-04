package bj16478;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        bw.write(Double.parseDouble(tc[0]) * Double.parseDouble(tc[2]) / Double.parseDouble(tc[1]) + "\n");
        bw.flush();
    }
}
