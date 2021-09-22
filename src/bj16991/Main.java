package bj16991;

import java.io.*;

public class Main {
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        double[][] weight = new double[n][n];
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            int y = Integer.parseInt(xy[1]);
            int x = Integer.parseInt(xy[0]);
            points[i] = new Point(y, x);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Point A = points[i];
                Point B = points[j];
                double w = Math.sqrt(Math.pow((B.x - A.x), 2) + Math.pow((B.y - A.y), 2));
                weight[i][j] = w;
                weight[j][i] = w;
            }
        }
        double[][] cost = new double[n][1 << n];
        bw.write(tsp(0, 0, weight, cost, n) + "");
        br.close();
        bw.close();
    }

    public static double tsp(int current, int visited, double[][] weight, double[][] cost, int n) {
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

    private static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}