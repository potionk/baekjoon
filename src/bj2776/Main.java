package bj2776;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Set<String> dupCheck = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            String[] noteOne = br.readLine().split(" ");
            Collections.addAll(dupCheck, noteOne);
            int M = Integer.parseInt(br.readLine());
            String[] noteTwo = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                if (dupCheck.contains(noteTwo[i])) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
        br.close();
        bw.close();
    }
}