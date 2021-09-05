package bj18406;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String score = br.readLine();
        int leftScore = 0, rightScore = 0;
        String left = score.substring(0, score.length() / 2);
        String right = score.substring(score.length() / 2);
        int len = left.length();
        for (int i = 0; i < len; i++) {
            leftScore += left.charAt(i) - '0';
            rightScore += right.charAt(i) - '0';
        }
        if (leftScore == rightScore) {
            bw.write("LUCKY");
        } else {
            bw.write("READY");
        }
        br.close();
        bw.close();
    }
}
