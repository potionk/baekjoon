package bj1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int count;
    public static int targetY, targetX;
    public static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isFinish = false;
        String[] input = br.readLine().split(" ");
        count = 0;
        int size = Integer.parseInt(input[0]);
        targetY = Integer.parseInt(input[1]);
        targetX = Integer.parseInt(input[2]);
        calZ(0, 0, (int) Math.pow(2, size));
    }

    public static void calZ(int row, int colomn, int size) {
        if (isFinish) {
            return;
        }
        if (targetY == row && targetX == colomn) {
            System.out.println(count);
            isFinish = true;
            return;
        } else if (targetY >= row + size) {
            count += size * size;
            return;
        } else if (targetX >= colomn + size) {
            count += size * size;
            return;
        } else if (size == 1) {
            count++;
            return;
        }
        size /= 2;
        calZ(row, colomn, size);
        calZ(row, colomn + size, size);
        calZ(row + size, colomn, size);
        calZ(row + size, colomn + size, size);
    }
}