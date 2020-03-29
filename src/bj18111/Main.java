package bj18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, blocks;
        int resultTime = Integer.MAX_VALUE, resultHeight = -1;
        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;
        String[] testCase = br.readLine().split(" ");
        N = Integer.parseInt(testCase[0]);
        M = Integer.parseInt(testCase[1]);
        blocks = Integer.parseInt(testCase[2]);
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }
        for (int i = minHeight; i <= maxHeight; i++) {
            int thisTime = 0;
            int thisBlock = blocks;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] < i) {
                        thisBlock -= (i - map[y][x]);
                        thisTime += (i - map[y][x]);
                    } else {
                        thisBlock += (map[y][x] - i);
                        thisTime += (map[y][x] - i) * 2;
                    }
                }
            }
            if (thisBlock >= 0) {
                if (resultTime >= thisTime) {
                    resultTime = thisTime;
                    resultHeight = i;
                }

            }
        }
        System.out.println(resultTime + " " + resultHeight);
    }
}