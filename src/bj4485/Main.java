package bj4485;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        int problemNum = 1;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int[][] cave = new int[N][N];
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] readLine = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(readLine[j]);
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            dist[0][0] = cave[0][0];
            dijkstra(new Point(0, 0), cave, dist, N);
            bw.write("Problem " + problemNum + ": " + dist[N - 1][N - 1] + "\n");
            problemNum++;
        }
        br.close();
        bw.close();
    }

    public static void dijkstra(Point startPoint, int[][] graph, int[][] dist, int n) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(startPoint, 0));
        while (!priorityQueue.isEmpty()) {
            Vertex v = priorityQueue.poll();
            int y = v.point.y;
            int x = v.point.x;
            int post = dist[y][x];
            if (v.weight == Integer.MAX_VALUE) {
                break;
            } else if (post >= v.weight) {
                for (int i = 0; i < 4; i++) {
                    int nextY = y + Y_ARROW[i];
                    int nextX = x + X_ARROW[i];
                    if (isValidatedPoint(nextY, nextX, n)) {
                        int weight = graph[nextY][nextX];
                        if (dist[nextY][nextX] > post + weight) {
                            priorityQueue.add(new Vertex(new Point(nextY, nextX), post + weight));
                            dist[nextY][nextX] = post + weight;
                        }
                    }
                }
            }
        }
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int n) {
        return !(nextY >= n) && !(nextX >= n) && !(nextY < 0) && !(nextX < 0);
    }

    private static class Point {
        int y;
        int x;

        private Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static class Vertex implements Comparable<Vertex> {
        Point point;
        int weight;

        private Vertex(Point point, int distance) {
            this.point = point;
            this.weight = distance;
        }

        @Override
        public int compareTo(Vertex v) {
            return Integer.compare(this.weight, v.weight);
        }
    }
}
