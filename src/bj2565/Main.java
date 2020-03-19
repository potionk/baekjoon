package bj2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        AB[] testCase = new AB[size];
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            testCase[i] = new AB(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }
        int[] dp = new int[testCase.length];
        dp[0] = 1;
        Arrays.sort(testCase);
        for (int i = 1; i < testCase.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (testCase[j].getB() < testCase[i].getB() && dp[j] > max) {
                    dp[i] = dp[j] + 1;
                    max = dp[j];
                }
            }
            if (dp[i] == 0)
                dp[i] = 1;
        }
        Arrays.sort(dp);
        System.out.println(size-dp[dp.length - 1]);
    }
}

class AB implements Comparable<AB> {
    int a;
    int b;

    public int getB() {
        return b;
    }

    public AB(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(AB target) {
        if (this.a < target.a) {
            return -1;
        } else if (this.a == target.a) {
            return 0;
        } else {
            return 1;
        }
    }
}