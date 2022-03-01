package bj2959;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int[] tc = new int[input.length];
        for (int i = 0; i < tc.length; i++) {
            tc[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(tc);
        bw.write(tc[0] * tc[2] + "");
        br.close();
        bw.close();
    }
}