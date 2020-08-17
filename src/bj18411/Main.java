package bj18411;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tcStr = br.readLine().split(" ");
        int[] tc = new int[3];
        for (int i = 0; i < 3; i++) {
            tc[i] = Integer.parseInt(tcStr[i]);
        }
        Arrays.sort(tc);
        System.out.println(tc[1] + tc[2]);
    }
}