package bj1735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] one = br.readLine().split(" ");
        long a1 = Integer.parseInt(one[0]);
        long b1 = Integer.parseInt(one[1]);
        String[] two = br.readLine().split(" ");
        long a2 = Integer.parseInt(two[0]);
        long b2 = Integer.parseInt(two[1]);
        long A = a1 * b2 + a2 * b1;
        long B = b1 * b2;
        long result = euclidean(A, B);
        System.out.println(A / result + " " + B / result);
    }

    public static long euclidean(long a, long b) {
        if (a % b == 0)
            return b;
        else
            return euclidean(b, a % b);
    }
}