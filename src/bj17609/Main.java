package bj17609;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            bw.write(isPalindrome(br.readLine()) + "\n");
        }
        br.close();
        bw.close();
    }

    static int isPalindrome(String input) {
        int inputLen = input.length();
        for (int i = 0; i < inputLen / 2; i++) {
            if (input.charAt(i) != input.charAt(inputLen - i - 1)) {
                if (i + 1 == inputLen - i) {
                    return 2;
                }
                if (isElsePalindrome(input, i, inputLen - i - 2)) {
                    return 1;
                } else {
                    if (isElsePalindrome(input, i + 1, inputLen - i - 1)) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    static boolean isElsePalindrome(String input, int start, int finish) {
        for (; start <= (start + finish) / 2; start++, finish--) {
            if (input.charAt(start) != input.charAt(finish)) {
                return false;
            }
        }
        return true;
    }
}