package bj16967;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int h = Integer.parseInt(info[0]);
        int w = Integer.parseInt(info[1]);
        int x = Integer.parseInt(info[2]);
        int y = Integer.parseInt(info[3]);
        int[][] b = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < w + y; j++) {
                b[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = b[i][j];
            }
        }
        for (int i = x; i < h + x; i++) {
            for (int j = y; j < w + y; j++) {
                if ((i >= h || j >= w)) {
                    a[i - x][j - y] = b[i][j];
                } else {
                    a[i][j] = b[i][j] - a[i - x][j - y];
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                bw.write(a[i][j] + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}