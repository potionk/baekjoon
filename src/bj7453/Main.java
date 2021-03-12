package bj7453;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int[] A = new int[tc];
        int[] B = new int[tc];
        int[] C = new int[tc];
        int[] D = new int[tc];
        for (int i = 0; i < tc; i++) {
            String[] abcd = br.readLine().split(" ");
            A[i] = Integer.parseInt(abcd[0]);
            B[i] = Integer.parseInt(abcd[1]);
            C[i] = Integer.parseInt(abcd[2]);
            D[i] = Integer.parseInt(abcd[3]);
        }
        int compLen = tc * tc;
        int[] AB = new int[compLen];
        int[] CD = new int[compLen];
        int idx = 0;
        for (int i = 0; i < tc; i++) {
            for (int j = 0; j < tc; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx++] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);
        int start = 0, end = compLen - 1;
        long result = 0;
        while (start < compLen && end >= 0) {
            int sum = AB[start] + CD[end];
            if (sum == 0) {
                int s = 0, e = 0;
                int ab = AB[start];
                int cd = CD[end];
                while (start < compLen && AB[start] == ab) {
                    start++;
                    s++;
                }
                while (end >= 0 && CD[end] == cd) {
                    end--;
                    e++;
                }
                result += (long) s * e;
            } else if (sum >= 0) {
                end--;
            } else {
                start++;
            }

        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}