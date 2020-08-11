package bj3192;

import java.io.*;
import java.util.*;

public class Main {
    static int[] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        square = new int[9];
        for (int i = 0; i < 3; i++) {
            String[] readline = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                square[i * 3 + j] = Integer.parseInt(readline[j]);
            }
        }
        Line[] lineArr = new Line[8];
        init(lineArr);
        Arrays.sort(lineArr);
        int total = 0;
        if (lineArr[7].getBlankSize() == 0) {
            total = lineArr[7].getTotal();
        } else {
            int[] blankArr = lineArr[0].getBlankIdxArr();
            if (blankArr[0] == 0 && blankArr[1] == 4 && blankArr[2] == 8) {
                total = (3 * square[2] + square[1] + square[5] + square[6]) / 2;
            } else {
                total = (3 * square[0] + square[1] + square[3] + square[8]) / 2;
            }
        }
        for (int i = 0; i < 8; i++) {
            if (lineArr[i].getBlankSize() == 1) {
                int[] idx = lineArr[i].getIdx();
                int elseTotal = 0;
                int blankIdx = lineArr[i].getBlankIdxArr()[0];
                for (int j = 0; j < 3; j++) {
                    if (idx[j] != blankIdx) {
                        elseTotal += square[idx[j]];
                    }
                }
                square[blankIdx] = total - elseTotal;
            }
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(square[i] + " ");
            if (i % 3 == 2)
                System.out.println();
        }
    }

    public static Line[] init(Line[] lineArr) {
        int[][] idx = {{0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}};
        for (int i = 0; i < 8; i++) {
            int blackSize = 0;
            int total = 0;
            int[] blankIdxArr = new int[3];
            for (int j = 0; j < 3; j++) {
                total += square[idx[i][j]];
                if (square[idx[i][j]] == 0) {
                    blankIdxArr[blackSize++] = idx[i][j];
                }
            }
            lineArr[i] = new Line(total, idx[i], blackSize, blankIdxArr);
        }
        return lineArr;
    }
}

class Line implements Comparable<Line> {
    int total;
    int[] idx;
    int blankSize;
    int[] blankIdxArr;

    public int getTotal() {
        return total;
    }

    public int[] getIdx() {
        return idx;
    }

    public int getBlankSize() {
        return blankSize;
    }

    public int[] getBlankIdxArr() {
        return blankIdxArr;
    }

    public Line(int total, int[] idx, int blankSize, int[] blankIdxArr) {
        this.total = total;
        this.idx = idx;
        this.blankSize = blankSize;
        this.blankIdxArr = blankIdxArr;
    }

    @Override
    public int compareTo(Line p) {
        if (this.blankSize < p.getBlankSize()) {
            return 1;
        } else if (this.blankSize == p.getBlankSize()) {
            return 0;
        }
        return -1;
    }
}