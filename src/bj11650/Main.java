package bj11650;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int pointNumber = Integer.parseInt(br.readLine());
        List<Point> pointList = new ArrayList<>(pointNumber);
        while (pointNumber-- > 0) {
            String[] input = br.readLine().split(" ");
            pointList.add(new Point(Integer.parseInt(input[1]), Integer.parseInt(input[0])));
        }
        pointList.sort(Comparator.comparing(Point::getX).thenComparing(Point::getY));
        for (Point p : pointList) {
            bw.write(p.getX() + " " + p.getY() + "\n");
        }
        br.close();
        bw.close();
    }
}

class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
