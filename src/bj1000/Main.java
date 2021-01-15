package bj1000;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        bw.write((Integer.parseInt(tc[0]) + Integer.parseInt(tc[1]))+"");
        br.close();
        bw.close();
    }
}
