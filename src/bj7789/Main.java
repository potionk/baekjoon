package bj7789;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] numInfo = br.readLine().split(" ");
        if ((new BigInteger(numInfo[0]).isProbablePrime(5) && (new BigInteger(numInfo[1] + numInfo[0]).isProbablePrime(5)))) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        br.close();
        bw.close();
    }
}
