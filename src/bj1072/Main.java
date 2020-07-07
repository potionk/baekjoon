package bj1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        double X = Double.parseDouble(testCase[0]);
        double Y = Double.parseDouble(testCase[1]);
        int Z = (int) (Y * 100 / X);
        if (Z == 100 || Z == 99) {
            System.out.println(-1);
        } else {
            int count = 1;
            while (((int) ((++Y * 100) / ++X)) == Z) {
                count++;
            }
            System.out.println(count);
        }
    }
}