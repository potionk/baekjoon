package bj1439;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        int[] bundle = new int[2];
        for (int i = 0; i < input.length; i++) {
            bundle[input[i] - '0']++;
            while (i + 1 < input.length && input[i] == input[i + 1]) {
                i++;
            }
        }
        bw.write(Math.min(bundle[0], bundle[1]) + "");
        br.close();
        bw.close();
    }
}