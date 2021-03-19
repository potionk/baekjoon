package bj2506;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] ox = br.readLine().split(" ");
        int result = 0;
        int score = 1;
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(ox[i]) == 1) {
                result += score;
                score++;
            } else {
                score=1;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}