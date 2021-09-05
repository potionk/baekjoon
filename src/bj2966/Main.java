package bj2966;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        char[] answer = br.readLine().toCharArray();
        int[] score = new int[3];
        char[][] sheet = {{'A', 'B', 'C'}, {'B', 'A', 'B', 'C'}, {'C', 'C', 'A', 'A', 'B', 'B'}};
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer[i] == sheet[j][i % sheet[j].length]) {
                    score[j]++;
                }
            }
        }
        int maxScore = 0;
        for (int s : score) {
            maxScore = Math.max(maxScore, s);
        }
        bw.write(maxScore + "\n");
        for (int i = 0; i < 3; i++) {
            if (maxScore == score[i]) {
                switch (i) {
                    case 0 -> bw.write("Adrian\n");
                    case 1 -> bw.write("Bruno\n");
                    case 2 -> bw.write("Goran\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}
