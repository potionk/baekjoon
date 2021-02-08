package bj8723;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputStr = br.readLine().split(" ");
        int[] input = new int[inputStr.length];
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(inputStr[i]);
        }
        if (input[0] == input[1] && input[2] == input[1]) {
            bw.write("2");
        } else {
            int squareOfA = input[0] * input[0];
            int squareOfB = input[1] * input[1];
            int squareOfC = input[2] * input[2];
            if ((squareOfA == squareOfB + squareOfC) || (squareOfB == squareOfA + squareOfC) || (squareOfC == squareOfA + squareOfB)) {
                bw.write("1");
            } else {
                bw.write("0");
            }
        }
        br.close();
        bw.close();
    }
}
