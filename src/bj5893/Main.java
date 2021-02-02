package bj5893;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        bw.write(binaryAdd(N + "0000", N) + "\n");
        br.close();
        bw.close();
    }

    public static String binaryAdd(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char carry = '0';
        if (a.length() > b.length()) {
            b = "0".repeat(a.length() - b.length()) + b;
        } else if (a.length() < b.length()) {
            a = "0".repeat(b.length() - a.length()) + a;
        }
        int len = a.length();
        for (int i = len - 1; i >= 0; i--) {
            int count = countOne(a.charAt(i), b.charAt(i), carry);
            switch (count) {
                case 0 -> {
                    carry = '0';
                    sb.insert(0, '0');
                }
                case 1 -> {
                    carry = '0';
                    sb.insert(0, '1');
                }
                case 2 -> {
                    carry = '1';
                    sb.insert(0, '0');
                }
                case 3 -> {
                    carry = '1';
                    sb.insert(0, '1');
                }
            }
        }
        if (carry == '1') {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static int countOne(char a, char b, char carry) {
        int count = 0;
        if (carry == '1') {
            count++;
        }
        if (a == '1') {
            count++;
        }
        if (b == '1') {
            count++;
        }
        return count;
    }
}