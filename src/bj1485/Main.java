package bj1485;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            XY[] xy = new XY[4];
            for (int a = 0; a < 4; a++) {
                String[] input = br.readLine().split(" ");
                xy[a] = new XY(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }
            Arrays.sort(xy);
            if (calDistance(xy[0], xy[1]) == calDistance(xy[2], xy[3]) && calDistance(xy[0], xy[2]) == calDistance(xy[1], xy[3]) && calDistance(xy[0], xy[1]) == calDistance(xy[0], xy[2]) && calDistance(xy[0], xy[3]) == calDistance(xy[1], xy[2]))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    public static long calDistance(XY a, XY b) {
        return (a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY());
    }
}

class XY implements Comparable<XY> {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(XY o) {
        if (this.x < o.x) {
            return -1;
        } else if (this.x > o.x) {
            return 1;
        } else {
            return Integer.compare(this.y, o.y);
        }
    }
}