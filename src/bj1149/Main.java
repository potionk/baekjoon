package bj1149;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[][][] price = new int[3][num][3];
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                for (int c = 0; c < 3; c++) {
                    price[c][i][j] = Integer.parseInt(input[j]);
                }
            }
        }
        for (int c = 0; c < 3; c++) {
            for (int i = 0; i < 3; i++) {
                if (c != i) {
                    price[c][0][i] = 1000000;
                }
            }
        }

        for (int i = 1; i < num; i++) {
            for (int c = 0; c < 3; c++) {
                price[c][i][0] += Math.min(price[c][i - 1][1], price[c][i - 1][2]);
                price[c][i][1] += Math.min(price[c][i - 1][0], price[c][i - 1][2]);
                price[c][i][2] += Math.min(price[c][i - 1][0], price[c][i - 1][1]);
            }
        }
        bw.write(min(price[0][num - 1][1], price[0][num - 1][2], price[1][num - 1][0], price[1][num - 1][2], price[2][num - 1][0], price[2][num - 1][1]) + "");
        bw.close();
        br.close();
    }

    public static int min(int a, int b, int c, int d, int e, int f) {
        int[] array = {a, b, c, d, e, f};
        Arrays.sort(array);
        return array[0];
    }
}