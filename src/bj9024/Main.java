package bj9024;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nK = br.readLine().split(" ");
            int n = Integer.parseInt(nK[0]);
            int K = Integer.parseInt(nK[1]);
            String[] SStr = br.readLine().split(" ");
            int[] S = new int[n];
            for (int i = 0; i < n; i++) {
                S[i] = Integer.parseInt(SStr[i]);
            }
            Arrays.sort(S);
            int start = 0, end = n - 1, sum = S[start] + S[end], result = 0;
            while (start < end) {
                int thisSum = S[start] + S[end];
                if (Math.abs(K - thisSum) < Math.abs(K - sum)) {
                    sum = thisSum;
                    result = 1;
                } else if (Math.abs(K - thisSum) == Math.abs(K - sum)) {
                    result++;
                }
                if (thisSum < K) {
                    start++;
                } else {
                    end--;
                }
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
