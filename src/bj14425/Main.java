package bj14425;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        Set<String> dupCheck = new HashSet<>();
        for (int i = 0; i < N; i++) {
            dupCheck.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (dupCheck.contains(br.readLine())) {
                count++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }
}
