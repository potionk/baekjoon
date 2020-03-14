package bj2523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int count = 1;
        boolean flag = false;
        if (testCase == 1) {
            System.out.println("*");
        } else {
            while (count != 0) {
                System.out.println(makeStar(count));
                if (!flag) {
                    count++;
                    if (count >= testCase) flag = true;
                } else {
                    count--;
                }
            }
        }
    }

    public static String makeStar(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}