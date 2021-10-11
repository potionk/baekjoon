package bj7490;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        while (tcNum-- > 0) {
            int n = Integer.parseInt(br.readLine());
            dfs(1, n, 1, 1, new int[n - 1], bw);
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int i, int n, int before, int total, int[] operation, BufferedWriter bw) throws IOException { // - : 0, + : 1, blank : 2
        if (i >= n) {
            if (total == 0) {
                for (int a = 1; a < n; a++) {
                    bw.write(a + "" + operationCodeToChar(operation[a - 1]));
                }
                bw.write(n + "\n");
            }
        } else {
            int next = i + 1;
            operation[i - 1] = 0;
            int nextBefore;
            if (before < 0) {
                nextBefore = before * 10 - next;
            } else {
                nextBefore = before * 10 + next;
            }
            dfs(next, n, nextBefore, total - before + nextBefore, operation, bw);
            operation[i - 1] = 1;
            dfs(next, n, next, total + next, operation, bw);
            operation[i - 1] = 2;
            dfs(next, n, -1 * next, total - next, operation, bw);

        }
    }

    public static char operationCodeToChar(int i) {
        switch (i) {
            case 0 -> {
                return ' ';
            }
            case 1 -> {
                return '+';
            }
            default -> {
                return '-';
            }
        }
    }
}
