package bj6194;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Point> points = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] pointInfo = br.readLine().split(" ");
            points.add(new Point(Integer.parseInt(pointInfo[1]), Integer.parseInt(pointInfo[0])));
        }
        points.sort(Comparator.comparing(Point::getY).thenComparing(Point::getX));
        Point p0 = points.pollFirst();
        points.sort((p1, p2) -> ccwCompare(ccw(p0, p2, p1)));
        points.addFirst(p0);
        bw.write(String.format("%.2f", calPerimeter(convexHull(points))));
        br.close();
        bw.close();
    }

    public static double calPerimeter(Stack<Point> stack) {
        double perimeter = 0;
        Point prevPoint = stack.pop();
        Point start = prevPoint;
        while (!stack.isEmpty()) {
            Point p = stack.pop();
            perimeter += Math.sqrt(Math.pow(Math.abs(prevPoint.x - p.x), 2) + Math.pow(Math.abs(prevPoint.y - p.y), 2));
            prevPoint = p;
        }
        perimeter += Math.sqrt(Math.pow(Math.abs(start.x - prevPoint.x), 2) + Math.pow(Math.abs(start.y - prevPoint.y), 2));
        return perimeter;
    }

    public static Stack<Point> convexHull(LinkedList<Point> points) {
        Stack<Point> stack = new Stack<>();
        stack.push(points.pollFirst());
        stack.push(points.pollFirst());
        while (!points.isEmpty()) {
            Point p3 = points.pop();
            while (stack.size() >= 2 && ccw(p3, stack.get(stack.size() - 2), stack.get(stack.size() - 1)) <= 0) {
                stack.pop();
            }
            stack.push(p3);
        }
        return stack;
    }

    public static long ccw(Point a, Point b, Point c) {
        return a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y - c.x * b.y - a.x * c.y;
    }

    public static int ccwCompare(long ccw) {
        if (ccw > 0) {
            return 1;
        } else if (ccw == 0) {
            return 0;
        } else {
            return -1;
        }
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