package bj14490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(":");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int result = euclidean(a, b);
        System.out.println(a / result + ":" + b / result);
    }

    public static int euclidean(int a, int b) {
        if (a % b == 0)
            return b;
        else
            return euclidean(b, a % b);
    }
}