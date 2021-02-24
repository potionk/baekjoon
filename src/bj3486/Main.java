package bj3486;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            String[] ab = br.readLine().split(" ");
            bw.write(removeLeadingZero(reverseString((Integer.parseInt(reverseString(ab[0])) + Integer.parseInt(reverseString(ab[1]))) + "")) + "\n");
        }
        br.close();
        bw.close();
    }

    public static String reverseString(String s) {
        return (new StringBuilder(s).reverse()).toString();
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
}