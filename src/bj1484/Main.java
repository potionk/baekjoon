package bj1484;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int G = Integer.parseInt(br.readLine());
        // (c+m)*(c-m)=G, c>m, c+m<G
        PriorityQueue<Integer> result = new PriorityQueue<>();
        Set<Integer> dupCheck = new HashSet<>();
        for (int i = 1; i <= G / 2; i++) {
            if (G % i == 0) {
                int j = G / i;
                if ((i + j) % 2 != 0) {
                    continue;
                }
                int c = (i + j) / 2;
                if ((i < j && i - c == c - j) || (i > j && j - c == c - i)) {
                    if (!dupCheck.contains(c)) {
                        dupCheck.add(c);
                        result.add(c);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            bw.write("-1");
        } else {
            while (!result.isEmpty()) {
                bw.write(result.poll() + "\n");
            }
        }
        br.close();
        bw.close();
    }
}