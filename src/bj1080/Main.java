package bj1080;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] A = new int[n][m];
        int[][] B = new int[n][m];
        for (int i = 0; i < n; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = readLine.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < m; j++) {
                B[i][j] = readLine.charAt(j) - '0';
            }
        }
        int result = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (A[i][j] != B[i][j]) {
                    swap(A, i, j);
                    result++;
                }
            }
        }
        boolean isEqual = true;
        for (int i = 0; i < n; i++) {
            if (!isEqual) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (A[i][j] != B[i][j]) {
                    isEqual = false;
                    break;
                }
            }
        }
        if (isEqual) {
            bw.write(result + "");
        } else {
            bw.write("-1");
        }
        br.close();
        bw.close();
    }

    private static void swap(int[][] A, int y, int x) {
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                switch (A[i][j]) {
                    case 1 -> A[i][j] = 0;
                    case 0 -> A[i][j] = 1;
                }
            }
        }
    }
}
