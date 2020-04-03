package bj5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1 + Integer.parseInt(br.readLine()) * 2;
        int testCaseSize = Integer.parseInt(br.readLine());
        char[] testCase = br.readLine().toCharArray();
        boolean isI = true;
        int count = 0;
        for (int i = 0; i < testCaseSize - N; i++) {
            for (int j = i; j < i + N; j++) {
                if (isI) {
                    if (testCase[j] != 'I')
                        break;
                    if (j == i + N - 1)
                        count++;
                    isI = false;
                } else {
                    if (testCase[j] != 'O')
                        break;
                    isI = true;
                }
            }
            isI=true;
        }
        System.out.println(count);
    }
}