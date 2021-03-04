package bj1339;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int wordNum = Integer.parseInt(br.readLine());
        int[] count = new int[26];
        while (wordNum-- > 0) {
            String word = br.readLine();
            int wordLen = word.length();
            for (int i = wordLen - 1, mul = 1; i >= 0; i--, mul *= 10) {
                count[word.charAt(i) - 'A'] += mul;
            }
        }
        Arrays.sort(count);
        int result = 0;
        for (int c = 9; c > 0; c--) {
            result += count[c + 16] * c;
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}