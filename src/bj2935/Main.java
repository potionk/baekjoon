package bj2935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String operator = br.readLine();
        String B = br.readLine();
        int[] result;
        if (operator.equals("+")) {
            result = new int[Math.max(A.length(), B.length())];
            if (A.equals(B))
                result[0] = 2;
            else {
                result[0] = 1;
                result[result.length - Math.min(A.length(), B.length())] = 1;
            }
        } else {
            result = new int[A.length() + B.length() - 1];
            result[0]=1;
        }
        for (int value : result) {
            System.out.print(value);
        }
    }
}