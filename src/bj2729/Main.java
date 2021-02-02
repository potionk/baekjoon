package bj2729;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] ab = br.readLine().split(" ");
            bw.write(removeLeadingZero(binaryAdd(ab[0], ab[1])) + "\n");
        }
        br.close();
        bw.close();
    }

    public static String removeLeadingZero(String num) {
        int count = 0, len = num.length();
        for (int i = 0; i < len; i++) {
            if (num.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        if (count == len) {
            return "0";
        }
        return num.substring(count);
    }

    public static String binaryAdd(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char carry = '0';
        if (a.length() > b.length()) {
            b = makeZeroStr(a.length() - b.length()) + b;
        } else if (a.length() < b.length()) {
            a = makeZeroStr(b.length() - a.length()) + a;
        }
        int len = a.length();
        for (int i = len - 1; i >= 0; i--) {
            int count = countOne(a.charAt(i), b.charAt(i), carry);
            switch (count) {
                case 0:
                    carry = '0';
                    sb.insert(0, '0');
                    break;
                case 1:
                    carry = '0';
                    sb.insert(0, '1');
                    break;
                case 2:
                    carry = '1';
                    sb.insert(0, '0');
                    break;
                case 3:
                    carry = '1';
                    sb.insert(0, '1');
                    break;
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

    public static String makeZeroStr(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
