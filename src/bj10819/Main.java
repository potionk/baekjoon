package bj10819;

import java.io.*;

public class Main {
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        max = -1;
        int size = Integer.parseInt(br.readLine());
        String[] tcStr = br.readLine().split(" ");
        int[] arr = new int[tcStr.length];
        boolean[] isVisited = new boolean[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(tcStr[i]);
        }
        for (int i = 0; i < size; i++) {
            isVisited[i] = true;
            dfs(arr, isVisited, 1, arr[i], 0, size);
            isVisited[i] = false;
        }
        bw.write(max + "");
        br.close();
        bw.close();
    }

    public static void dfs(int[] arr, boolean[] isVisited, int count, int before, int total, int size) {
        if (count == size) {
            max = Math.max(total, max);
        } else {
            for (int i = 0; i < size; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(arr, isVisited, count + 1, arr[i], total + Math.abs(before - arr[i]), size);
                    isVisited[i] = false;
                }
            }
        }
    }
}
