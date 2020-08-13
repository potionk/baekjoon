package bj11441;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        String[] tcStr = br.readLine().split(" ");
        int[] tc = new int[tcStr.length];
        for (int i = 0; i < tc.length; i++) {
            tc[i] = Integer.parseInt(tcStr[i]);
        }
        int[] cumSum = new int[tc.length];
        cumSum[0] = tc[0];
        for (int i = 1; i < cumSum.length; i++) {
            cumSum[i] = cumSum[i - 1] + tc[i];
        }
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int finish = Integer.parseInt(input[1]);
            if (start == 1) {
                bw.write(cumSum[finish - 1] + "\n");
            } else if (start == finish) {
                bw.write(tc[start - 1] + "\n");
            } else {
                bw.write((cumSum[finish - 1] - cumSum[start - 2]) + "\n");
            }
        }
        bw.flush();
    }
}