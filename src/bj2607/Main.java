package bj2607;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        char[] count = new char[26];
        for (char c : s) {
            count[c - 'A']++;
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            char[] tc = br.readLine().toCharArray();
            int lenDiff = Math.abs(tc.length - s.length);
            if (lenDiff < 2) {
                char[] tcCount = new char[26];
                int diff = lenDiff;
                for (char c : tc) {
                    tcCount[c - 'A']++;
                }
                for (int j = 0; j < 26; j++) {
                    diff += Math.abs(count[j] - tcCount[j]);
                }
                if (diff <= 2) {
                    result++;
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
