package bj2217;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tc = new int[N];
        for (int i = 0; i < N; i++) {
            tc[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tc);
        int result = -1;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, tc[i] * (N - i));
        }
        System.out.println(result);
    }
}
