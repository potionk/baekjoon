package bj9033;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            String[] input = br.readLine().split(" ");
            for (String s : input) {
                bw.write((new StringBuffer(s)).reverse().toString() + " ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}