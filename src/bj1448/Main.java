package bj1448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] straws = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            straws[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(straws);
        for (int i = testCase - 1; i >= 2; i--) {
            if (straws[i] < straws[i - 1] + straws[i - 2]) {
                System.out.println(straws[i] + straws[i - 1] + straws[i - 2]);
                return;
            }
        }
        System.out.println(-1);
    }
}
