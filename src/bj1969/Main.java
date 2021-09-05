package bj1969;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        char[][] dna = new char[N][M];
        for (int i = 0; i < N; i++) {
            String d = br.readLine();
            for (int j = 0; j < M; j++) {
                dna[i][j] = d.charAt(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 0; i < M; i++) {
            int[] count = new int[4]; // ACGT
            for (int j = 0; j < N; j++) {
                switch (dna[j][i]) {
                    case 'A' -> count[0]++;
                    case 'C' -> count[1]++;
                    case 'G' -> count[2]++;
                    case 'T' -> count[3]++;
                }
            }
            int hammingDistance = N;
            char minHammingDistanceChar = ' ';
            for (int j = 0; j < 4; j++) {
                if (N - count[j] < hammingDistance) {
                    hammingDistance = N - count[j];
                    switch (j) {
                        case 0 -> minHammingDistanceChar = 'A';
                        case 1 -> minHammingDistanceChar = 'C';
                        case 2 -> minHammingDistanceChar = 'G';
                        case 3 -> minHammingDistanceChar = 'T';
                    }
                }
            }
            sb.append(minHammingDistanceChar);
            result += hammingDistance;
        }
        bw.write(sb.toString() + "\n" + result);
        br.close();
        bw.close();
    }
}
