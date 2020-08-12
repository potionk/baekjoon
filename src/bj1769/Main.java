package bj1769;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] tc = br.readLine().toCharArray();
        int count = 0;
        while (tc.length != 1) {
            int t = 0;
            for (char c : tc) {
                t += c - '0';
            }
            tc = (t + "").toCharArray();
            count++;
        }
        System.out.println(count);
        if ((tc[0] - '0') % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}