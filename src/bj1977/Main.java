package bj1977;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.parseInt(br.readLine());
        int max = Integer.parseInt(br.readLine());
        boolean[] isFQ = new boolean[10001];
        for (int i = 1; i <= 100; i++) {
            isFQ[i * i] = true;
        }
        boolean isFirst = true;
        int minValue = -1;
        int total = 0;
        for (int i = min; i <= max; i++) {
            if (isFQ[i]) {
                if (isFirst) {
                    isFirst = false;
                    minValue = i;
                }
                total += i;
            }
        }
        if(!isFirst)
            System.out.println(total);
        System.out.println(minValue);
    }
}