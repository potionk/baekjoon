package bj12813;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                bw.write(A[i]);
            } else {
                bw.write("0");
            }
        }
        bw.write("\n");
        for (int i = 0; i < A.length; i++) {
            if (A[i] == '1' || B[i] == '1') {
                bw.write("1");
            } else {
                bw.write("0");
            }
        }
        bw.write("\n");
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                bw.write("1");
            } else {
                bw.write("0");
            }
        }
        bw.write("\n");
        for (char c : A) {
            if (c == '0') {
                bw.write("1");
            } else {
                bw.write("0");
            }
        }
        bw.write("\n");
        for (char c : B) {
            if (c == '0') {
                bw.write("1");
            } else {
                bw.write("0");
            }
        }

        br.close();
        bw.close();
    }
}
