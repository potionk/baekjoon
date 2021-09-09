package bj1261;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int xSize = Integer.parseInt(NM[0]);
        int ySize = Integer.parseInt(NM[1]);
        int[][] map = new int[ySize][xSize];
        int[][] dist = new int[ySize][xSize];
        for (int i = 0; i < ySize; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < xSize; j++) {
                map[i][j] = readLine.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = map[0][0];
        dijkstra(new Point(0, 0), map, dist, ySize, xSize);
        bw.write(dist[ySize - 1][xSize - 1] + "\n");
        br.close();
        bw.close();
    }

    public static void dijkstra(Point startPoint, int[][] graph, int[][] dist, int ySize, int xSize) {
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
                    if (isValidatedPoint(nextY, nextX, ySize, xSize)) {
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

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
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