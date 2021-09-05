package bj16499;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<String> dupCheck = new HashSet<>();
        while (N-- > 0) {
            char[] word = br.readLine().toCharArray();
            Arrays.sort(word);
            dupCheck.add(new String(word));
        }
        bw.write(dupCheck.size() + "");
        br.close();
        bw.close();
    }
}
