package bj11948;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int scienceTotal = 0;
        int scienceMin = Integer.MAX_VALUE, elseScoreMax = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            int score = Integer.parseInt(br.readLine());
            scienceMin = Math.min(score, scienceMin);
            scienceTotal += score;
        }
        for (int i = 0; i < 2; i++) {
            int score = Integer.parseInt(br.readLine());
            elseScoreMax = Math.max(score, elseScoreMax);
        }
        bw.write((scienceTotal - scienceMin + elseScoreMax) + "");
        br.close();
        bw.close();
    }
}