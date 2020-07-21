package bj11403;

import java.io.*;

public class Main {
    static int size;
    static boolean[] dfsVisited;
    static int[][] adjArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        adjArr = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                adjArr[i][j] = Integer.parseInt(input[j]);
            }
        }
        for (int i = 0; i < size; i++) {
            dfsVisited = new boolean[size];
            dfs(i);
            for (int j = 0; j < size; j++) {
                if (dfsVisited[j]) {
                    bw.write(1 + " ");
                } else {
                    bw.write(0 + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static void dfs(int index) {
        for (int i = 0; i < size; i++) {
            if (adjArr[index][i] == 1 && !dfsVisited[i]) {
                dfsVisited[i] = true;
                dfs(i);
            }
        }
    }
}
