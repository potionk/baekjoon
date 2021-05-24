package bj14002;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] testCaseStr = br.readLine().split(" ");
        int[] testCase = new int[N];
        Data[] dp = new Data[N];
        for (int i = 0; i < N; i++) {
            testCase[i] = Integer.parseInt(testCaseStr[i]);
            dp[i] = new Data(1, testCase[i] + "");
        }
        dp[0].max = 1;
        for (int i = 1; i < N; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (testCase[j] < testCase[i] && dp[j].max > max) {
                    dp[i].max = dp[j].max + 1;
                    dp[i].route = dp[j].route + " " + testCase[i];
                    max = dp[j].max;
                }
            }
        }
        Arrays.sort(dp);
        bw.write(dp[dp.length - 1].max + "\n" + dp[dp.length - 1].route);
        bw.close();
        br.close();
    }

    private static class Data implements Comparable<Data> {
        int max;
        String route;

        Data(int max, String route) {
            this.max = max;
            this.route = route;
        }

        @Override
        public int compareTo(Data o) {
            return Integer.compare(this.max, o.max);
        }
    }
}