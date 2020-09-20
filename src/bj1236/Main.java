package bj1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int ySize = Integer.parseInt(size[0]);
        int xSize = Integer.parseInt(size[1]);
        char[][] map = new char[ySize][xSize];
        int xCount = 0;
        int yCount = 0;
        for (int i = 0; i < ySize; i++) {
            char[] input = br.readLine().toCharArray();
            boolean isFind = false;
            for (int j = 0; j < xSize; j++) {
                map[i][j] = input[j];
                if (map[i][j] == 'X') {
                    isFind = true;
                }
            }
            if (!isFind) {
                yCount++;
            }
        }
        for (int i = 0; i < xSize; i++) {
            boolean isFind = false;
            for (int j = 0; j < ySize; j++) {
                if (map[j][i] == 'X') {
                    isFind = true;
                }
            }
            if (!isFind) {
                xCount++;
            }
        }
        System.out.println(xCount + yCount - Math.min(xCount, yCount));
    }
}