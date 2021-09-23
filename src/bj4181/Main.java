package bj4181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Point> points = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String[] pointInfo = br.readLine().split(" ");
            if (pointInfo[2].equals("Y")) {
                points.add(new Point(Integer.parseInt(pointInfo[1]), Integer.parseInt(pointInfo[0])));
            }
        }
        points.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        Point p0 = points.pollFirst();
        points.sort((p1, p2) -> ccwCompare(p0, p2, p1));
        points.addFirst(p0);
        convexHull(points, bw);
        br.close();
        bw.close();
    }

    public static void convexHull(LinkedList<Point> points, BufferedWriter bw) throws IOException {
        bw.write(points.size() + "\n");
        Stack<Point> stack = new Stack<>();
        stack.push(points.pollFirst());
        Point p2 = stack.push(points.pollFirst());
        for (Point point : points) {
            while (stack.size() >= 2 && ccw(point, stack.get(stack.size() - 2), stack.get(stack.size() - 1)) < 0) {
                stack.pop();
            }
            stack.push(point);
        }
        List<Point> elsePoints = new ArrayList<>();
        points.add(p2);
        for (Point point : points) {
            if (!stack.contains(point)) {
                elsePoints.add(point);
            }
        }
        elsePoints.sort(Comparator.comparingLong(p -> dist(points.get(0), p)));
        for (Point point : stack) {
            bw.write(point.x + " " + point.y + "\n");
        }
        if (!elsePoints.isEmpty()) {
            for (int i = elsePoints.size() - 1; i >= 0; i--) {
                bw.write(elsePoints.get(i).x + " " + elsePoints.get(i).y + "\n");
            }
        }
    }

    public static long ccw(Point a, Point b, Point c) {
        return a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y - c.x * b.y - a.x * c.y;
    }

    public static int ccwCompare(Point a, Point b, Point c) {
        long ccw = ccw(a, b, c);
        if (ccw > 0) {
            return 1;
        } else if (ccw == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    static long dist(Point p1, Point p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }

    private static class Point {
        long x;
        long y;

        public Point(long y, long x) {
            this.y = y;
            this.x = x;
        }

        public long getX() {
            return x;
        }

        public long getY() {
            return y;
        }
    }
}