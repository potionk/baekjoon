package bj1269;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        int ALen = Integer.parseInt(size[0]);
        int BLen = Integer.parseInt(size[1]);
        int intersection = 0;
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        Set<String> union = new HashSet<>(Arrays.asList(A).subList(0, ALen));
        for (int i = 0; i < BLen; i++) {
            if (union.contains(B[i])) {
                intersection++;
            }
            union.add(B[i]);
        }
        bw.write((union.size() - intersection) + "\n");
        br.close();
        bw.close();
    }
}