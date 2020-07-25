package bj2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] tc = new int[testCase];
        String[] input = br.readLine().split(" ");
        int max = Integer.parseInt(br.readLine());
        for (int i = 0; i < input.length; i++) {
            tc[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(tc);
        int low = 0;
        int high = tc[testCase - 1];
        long result = 0;
        int resultMid=0;
        while (low <= high) {
            int mid = (high + low) / 2;
            long total = getTotal(tc, mid);
            if (total > max) {
                high = mid - 1;
            } else {
                if (result < total) {
                    result = total;
                    resultMid=mid;
                }
                low = mid + 1;
            }
        }
        System.out.println(resultMid);
    }

    public static long getTotal(int[] arr, int max) {
        long result = 0;
        for (int value : arr) {
            if (value <= max) {
                result += value;
            } else {
                result += max;
            }
        }
        return result;
    }
}
