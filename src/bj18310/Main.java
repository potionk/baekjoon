package bj18310;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] houseStr = br.readLine().split(" ");
        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = Integer.parseInt(houseStr[i]);
        }
        Arrays.sort(house);
        if (n % 2 == 1) {
            bw.write(house[n / 2] + "");
        } else {
            bw.write(house[n / 2 - 1] + "");
        }
        br.close();
        bw.close();
    }
}