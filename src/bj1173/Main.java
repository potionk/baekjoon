package bj1173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int X = Integer.parseInt(tc[1]);
        int max = Integer.parseInt(tc[2]);
        int T = Integer.parseInt(tc[3]);
        int R = Integer.parseInt(tc[4]);
        int count = 0;
        int min = X;
        for (int i = 0; i < N; ) {
            if (X + T <= max) {
                i++;
                X += T;
            } else {
                X -= R;
                if (X < min) {
                    X = min;
                }
            }
            if (X + T > max && X == min) {
                System.out.println(-1);
                return;
            }
            count++;
        }
        System.out.println(count);
    }
}
