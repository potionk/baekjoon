package bj13866;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] skillLevelStr = br.readLine().split(" ");
        int[] skillLevel = new int[4];
        for (int i = 0; i < 4; i++) {
            skillLevel[i] = Integer.parseInt(skillLevelStr[i]);
        }
        Arrays.sort(skillLevel);
        bw.write(Math.abs(skillLevel[0] + skillLevel[3] - skillLevel[1] - skillLevel[2]) + "");
        br.close();
        bw.close();
    }
}
