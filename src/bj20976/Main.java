package bj20976;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int[] tcInteger = new int[3];
        for (int i = 0; i < 3; i++) {
            tcInteger[i] = Integer.parseInt(tc[i]);
        }
        Arrays.sort(tcInteger);
        bw.write(tcInteger[1]+"");
        br.close();
        bw.close();
    }
}
