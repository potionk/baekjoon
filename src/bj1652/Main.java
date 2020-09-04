package bj1652;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        char[][] map = new char[size][size];
        int widthAvail = 0, heightAvail = 0;
        for (int i = 0; i < size; i++) {
            char[] input = br.readLine().toCharArray();
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (input[j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        widthAvail++;
                    }
                    count = 0;
                }
                map[i][j] = input[j];
            }
            if (count >= 2) {
                widthAvail++;
            }
        }
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (map[j][i] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        heightAvail++;
                    }
                    count = 0;
                }
            }
            if (count >= 2) {
                heightAvail++;
            }
        }
        bw.write(widthAvail + " " + heightAvail + "\n");
        bw.flush();
    }
}
