package bj1551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        int K = Integer.parseInt(testCase[1]);
        String[] arr = br.readLine().split(",");
        int[] A = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            A[i] = Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < K; i++) {
            A = transform(A);
        }
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
            if (i != A.length - 1)
                System.out.print(",");
        }
    }

    public static int[] transform(int[] A) {
        int[] B = new int[A.length - 1];
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i + 1] - A[i];
        }
        return B;
    }
}