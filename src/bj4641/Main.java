package bj4641;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        while (!(input = br.readLine()).equals("-1")) {
            String[] tcStr = input.split(" ");
            Set<Integer> set = new HashSet<>();
            int[] tc = new int[tcStr.length - 1];
            for (int i = 0; i < tc.length; i++) {
                tc[i] = Integer.parseInt(tcStr[i]);
                set.add(tc[i]);
            }
            int result = 0;
            for (int i : tc) {
                if (set.contains(i * 2)) {
                    result++;
                }
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
