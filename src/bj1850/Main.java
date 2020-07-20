package bj1850;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] testCase = br.readLine().split(" ");
        long A = Long.parseLong(testCase[0]);
        long B = Long.parseLong(testCase[1]);
        long gcd=euclidean(A,B);
        for(int i=0; i<gcd; i++){
            bw.write("1");
        }
        bw.flush();
    }

    public static long euclidean(long a, long b) {
        if (a % b == 0) {
            return b;
        } else {
            return euclidean(b, a % b);
        }
    }
}
