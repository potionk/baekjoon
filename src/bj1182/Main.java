package bj1182;

import java.io.*;

public class Main {
    static int[] data;
    static int N, S, count;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        N = Integer.parseInt(tc[0]);
        S = Integer.parseInt(tc[1]);
        isVisited = new boolean[N];
        String[] dataStr = br.readLine().split(" ");
        data = new int[dataStr.length];
        for (int i = 0; i < dataStr.length; i++) {
            data[i] = Integer.parseInt(dataStr[i]);
        }
        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            dfs(i, data[i]);
            isVisited[i] = false;
        }
        System.out.println(count);
    }

    public static void dfs(int index, int result) {
        if (index < N) {
            if (result == S) {
                count++;
            }
            for (int i = index + 1; i < N; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(i, result + data[i]);
                    isVisited[i] = false;
                }
            }
        }
    }
}