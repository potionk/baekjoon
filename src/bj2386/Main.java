package bj2386;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("#")) {
            char target = input.charAt(0);
            char[] sentence = input.substring(2).toLowerCase().toCharArray();
            int[] count = new int[26];
            for (char c : sentence) {
                if ('a' <= c && c <= 'z') {
                    count[c - 'a']++;
                }
            }
            bw.write(target + " " + count[target - 'a'] + "\n");
        }
        br.close();
        bw.close();
    }
}
