package bj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int count = 0;
        String[] read = br.readLine().split(" ");
        for (int j = 0; j < read.length; j++) {
            boolean isPrimeNum = true;
            int readData = Integer.parseInt(read[j]);
            for (int k = 2; k < readData; k++) {
                if (readData % k == 0) {
                    isPrimeNum = false;
                    break;
                }
            }
            if (readData!=1&&isPrimeNum)
                count++;
        }
        System.out.println(count);
    }
}