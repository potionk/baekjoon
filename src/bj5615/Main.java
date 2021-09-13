package bj5615;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while (n-- > 0) {
            BigInteger tc = new BigInteger(br.readLine());
            tc = tc.multiply(BigInteger.TWO);
            tc = tc.add(BigInteger.ONE);
            if (tc.isProbablePrime(10)) {
                count++;
            }
        }
        bw.write(count + "");
        br.close();
        bw.close();
    }
}
