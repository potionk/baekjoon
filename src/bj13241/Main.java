package bj13241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        long result = euclidean(a, b);
        System.out.println(a * b / result);
    }

    public static long euclidean(long a, long b) {
        if (a % b == 0)
            return b;
        else
            return euclidean(b, a % b);
    }
}