package bj2529;

import java.io.*;

public class Main {
    static String[] inequalitySign;
    static int k;
    static Long min, max;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        inequalitySign = br.readLine().split(" ");
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        isVisited = new boolean[10];
        for (int i = 0; i < 10; i++) {
            findNext(-1, i, 0);
        }
        System.out.println(unifyFormat(max));
        System.out.println(unifyFormat(min));
    }

    public static void dfs(int index, long result) {
        if (index < k) {
            int before = (int) (result % 10);
            if (inequalitySign[index].equals(">")) {
                for (int i = before - 1; i >= 0; i--) {
                    findNext(index, i, result);
                }
            } else {
                for (int i = before + 1; i < 10; i++) {
                    findNext(index, i, result);
                }
            }
        }
    }

    public static void findNext(int index, int i, long result) {
        if (!isVisited[i]) {
            if (index == k - 1) {
                max = Math.max(max, result * 10 + i);
                min = Math.min(min, result * 10 + i);
            }
            isVisited[i] = true;
            dfs(index + 1, result * 10 + i);
            isVisited[i] = false;
        }
    }

    public static String unifyFormat(long input) {
        String inputStr = input + "";
        if (inputStr.length() < k + 1) {
            return "0" + input;
        } else {
            return inputStr;
        }
    }
}