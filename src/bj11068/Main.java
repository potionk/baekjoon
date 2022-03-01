package bj11068;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            boolean palindrome = false;
            for (int i = 2; i <= 64; i++) {
                if (isPalindrome(convertNumeralSystem(num, i))) {
                    palindrome = true;
                    break;
                }
            }
            if (palindrome) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }
        br.close();
        bw.close();
    }

    public static String convertNumeralSystem(int num, int n) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.insert(0, (char) (num % n + 32));
            num /= n;
        }
        return sb.toString();
    }

    static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1))
                return false;
        }
        return true;
    }
}
