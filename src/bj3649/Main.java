package bj3649;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String xInput;
        while ((xInput = br.readLine()) != null) {
            int x = Integer.parseInt(xInput) * 10000000;
            int blockNum = Integer.parseInt(br.readLine());
            int[] block = new int[blockNum];
            for (int i = 0; i < blockNum; i++) {
                block[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(block);
            int start = 0, end = blockNum - 1, resultA = 0, resultB = 0;
            boolean isFind = false;
            while (start < end) {
                int sum = block[start] + block[end];
                if (sum == x) {
                    resultA = block[start];
                    resultB = block[end];
                    isFind = true;
                    break;
                }
                if (sum < x) {
                    start++;
                } else {
                    end--;
                }
            }
            if (!isFind) {
                bw.write("danger\n");
            } else {
                bw.write("yes " + resultA + " " + resultB + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
