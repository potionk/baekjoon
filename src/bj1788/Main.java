package bj1788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] fibo = new long[2000001];

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if (input > 0) {
            System.out.println(1);
            System.out.println(fibo[input]);
        } else if (input == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            long result = fibo[input * -1 + 1000000];
            if (result > 0) {
                System.out.println(1);
                System.out.println(result);
            } else {
                System.out.println(-1);
                System.out.println(-1 * result);
            }
        }
    }

    public static void init() {
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= 1000000; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000000;
        }
        fibo[1000001] = 1;
        fibo[1000002] = -1;
        for (int i = 1000003; i <= 2000000; i++) {
            fibo[i] = (fibo[i - 2] - fibo[i - 1]) % 1000000000;
        }
    }
}