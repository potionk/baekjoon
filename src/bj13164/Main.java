package bj13164;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        String[] costStrArr = br.readLine().split(" ");
        int[] costArr = new int[N];
        int[] gapArr = new int[N - 1];
        for (int i = 0; i < N; i++) {
            costArr[i] = Integer.parseInt(costStrArr[i]);
        }
        Arrays.sort(costArr);
        for (int i = 0; i < N - 1; i++) {
            gapArr[i] = costArr[i + 1] - costArr[i];
        }
        Arrays.sort(gapArr);
        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += gapArr[i];
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
