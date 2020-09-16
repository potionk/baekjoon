package bj2947;

import java.io.*;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tcStr = br.readLine().split(" ");
        int[] tc = new int[tcStr.length];
        for (int i = 0; i < tcStr.length; i++) {
            tc[i] = Integer.parseInt(tcStr[i]);
        }
        while (!isCorrectArr(tc)) {
            for (int i = 1; i < tc.length; i++) {
                if (tc[i - 1] > tc[i]) {
                    int t = tc[i];
                    tc[i] = tc[i - 1];
                    tc[i - 1] = t;
                    printArr(tc);
                }
            }
        }
        bw.flush();
    }

    public static boolean isCorrectArr(int[] arr) {
        for (int i = 0; i < 5; i++) {
            if (arr[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    public static void printArr(int[] arr) throws IOException {
        for (int i = 0; i < 5; i++) {
            bw.write(arr[i] + " ");
        }
        bw.write("\n");
    }
}