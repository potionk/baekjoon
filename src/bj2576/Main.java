package bj2576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 7; i++) {
            int tc = Integer.parseInt(br.readLine());
            if (tc % 2 == 1) {
                total += tc;
                min = Math.min(tc, min);
            }
        }
        if (total != 0) {
            System.out.println(total);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}