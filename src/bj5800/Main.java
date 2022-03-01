package bj5800;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        for (int i = 1; i <= k; i++) {
            bw.write("Class " + i + "\n");
            String[] scoreArrStr = br.readLine().split(" ");
            int[] scoreArr = new int[scoreArrStr.length - 1];
            for (int j = 0; j < scoreArr.length; j++) {
                scoreArr[j] = Integer.parseInt(scoreArrStr[j + 1]);
            }
            Arrays.sort(scoreArr);
            int maxGap = -1;
            for (int j = 0; j < scoreArr.length - 1; j++) {
                maxGap = Math.max(Math.abs(scoreArr[j] - scoreArr[j + 1]), maxGap);
            }
            bw.write("Max " + scoreArr[scoreArr.length - 1] + ", Min " + scoreArr[0] + ", Largest gap " + maxGap + "\n");
        }
        br.close();
        bw.close();
    }
}