package bj2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int count = 0;
        while (A > 0) {
            if (A % 5 == 0) {
                A -= 5;
                count++;
            } else if (A % 3 == 0) {
                A -= 3;
                count++;
            } else if (A > 5) {
                A -= 5;
                count++;
            } else {
                count = -1;
                break;
            }
        }
        System.out.println(count);
    }
}