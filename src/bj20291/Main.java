package bj20291;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        Map<String, Integer> laptop = new LinkedHashMap<>();
        for (int i = 0; i < tcNum; i++) {
            String[] fileName = br.readLine().split("\\.");
            laptop.merge(fileName[fileName.length - 1], 1, (a, b) -> laptop.get(fileName[fileName.length - b]) + b);
        }
        String[] extensions = new String[laptop.size()];
        int idx = 0;
        for (String s : laptop.keySet()) {
            extensions[idx++] = s;
        }
        Arrays.sort(extensions);
        for (String s : extensions) {
            bw.write(s + " " + laptop.get(s) + "\n");
        }
        br.close();
        bw.close();
    }
}
