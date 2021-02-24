package bj19602;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int S = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        if (calHappinessScore(S, M, L) >= 10) {
            bw.write("happy");
        } else {
            bw.write("sad");
        }
        br.close();
        bw.close();
    }

    public static int calHappinessScore(int S, int M, int L) {
        return S + 2 * M + 3 * L;
    }
}