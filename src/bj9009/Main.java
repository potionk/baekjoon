package bj9009;

import java.io.*;

public class Main {
    static int[] dp;
    static boolean[] isVisited;
    static int target;
    static String answer;
    static boolean isFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcNum = Integer.parseInt(br.readLine());
        dp = new int[46]; // 45번째부터 10억 넘어감
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 46; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        for (int i = 0; i < tcNum; i++) {
            target = Integer.parseInt(br.readLine());
            isFind = false;
            int startIdx = 0;
            for (int j = 0; j < dp.length - 1; j++) {
                if (target >= dp[j] && target < dp[j + 1]) {
                    startIdx = j;
                    break;
                }
            }
            isVisited = new boolean[startIdx + 1];
            dfs(startIdx, dp[startIdx] + "", dp[startIdx]);
            System.out.println(answer);
        }
    }

    public static void dfs(int startIdx, String result, int total) {
        if (total == target) {
            answer = result;
            isFind = true;
        } else if (total > target) {
            return;
        }
        for (int i = startIdx - 1; i >= 0; i--) {
            if (!isVisited[i] && !isFind) {
                isVisited[i] = true;
                dfs(startIdx - 1, dp[i] + " " + result, total + dp[i]);
                isVisited[i] = false;
            }
        }
    }
}