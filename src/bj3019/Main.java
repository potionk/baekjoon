package bj3019;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][][] block = {
                {{0}, {0, 0, 0, 0}},
                {{0, 0}},
                {{0, 0, 1}, {1, 0}},
                {{1, 0, 0}, {0, 1}},
                {{0, 0, 0}, {1, 0}, {0, 1}, {1, 0, 1}},
                {{0, 0, 0}, {0, 0}, {2, 0}, {0, 1, 1}},
                {{0, 0, 0}, {0, 0}, {0, 2}, {1, 1, 0}}
        };
        String[] CP = br.readLine().split(" ");
        int C = Integer.parseInt(CP[0]);
        int P = Integer.parseInt(CP[1]);
        int[] map = new int[C];
        String[] mapStr = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            map[i] = Integer.parseInt(mapStr[i]);
        }
        int count = 0;
        for (int i = 0; i < C; i++) {
            int[][] needMapArr = block[P - 1];
            for (int[] needMap : needMapArr) {
                if (i + needMap.length <= C) {
                    int[] thisMap = Arrays.copyOfRange(map, i, i + needMap.length);
                    int min = Integer.MAX_VALUE;
                    for (int k = 0; k < needMap.length; k++) {
                        min = Math.min(min, thisMap[k]);
                    }
                    boolean isMatch = true;
                    for (int k = 0; k < needMap.length; k++) {
                        if (thisMap[k] != needMap[k] + min) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) {
                        count++;
                    }
                }
            }
        }
        bw.write(count + "");
        br.close();
        bw.close();
    }
}
