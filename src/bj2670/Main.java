package bj2670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        double[] data = new double[testCase];
        double[] dp = new double[testCase];
        for (int i = 0; i < testCase; i++) {
            data[i] = Double.parseDouble(br.readLine());
        }
        double max = -1;
        for (int i = 0; i < testCase; i++) {
            dp[i] = data[i];
            double res = data[i];
            for (int j = i + 1; j < testCase; j++) {
                res *= data[j];
                dp[i] = Math.max(dp[i], res);
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(String.format("%.3f", max));
    }
}
