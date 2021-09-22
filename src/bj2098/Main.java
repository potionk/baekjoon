package bj2098;

import java.io.*;

public class Main {
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                weight[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int[][] cost = new int[n][1 << n];
        bw.write(tsp(0, 0, weight, cost, n) + "");
        br.close();
        bw.close();
    }

    public static int tsp(int current, int visited, int[][] weight, int[][] cost, int n) {
        visited |= (1 << current);
        if (visited == (1 << n) - 1) {
            if (weight[current][0] > 0) {
                return weight[current][0];
            } else {
                return INF;
            }
        }
        if (cost[current][visited] > 0) {
            return cost[current][visited];
        } else {
            cost[current][visited] = INF;
            for (int i = 0; i < n; i++) {
                if (i != current && (visited & (1 << i)) == 0 && weight[current][i] > 0) {
                    cost[current][visited] = Math.min(tsp(i, visited, weight, cost, n) + weight[current][i], cost[current][visited]);
                }
            }
        }
        return cost[current][visited];
    }
}
