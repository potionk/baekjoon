package bj2153;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] word = br.readLine().toCharArray();
        int result = 0;
        for (char c : word) {
            if ('a' <= c && c <= 'z') {
                result += c - 'a' + 1;
            } else {
                result += c - 'A' + 27;
            }

        }
        boolean prime = true;
        for (int i = 2; i < result; i++) {
            if (result % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            bw.write("It is a prime word.");
        } else {
            bw.write("It is not a prime word.");
        }
        br.close();
        bw.close();
    }
}
