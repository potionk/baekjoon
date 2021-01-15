package bj2204;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            Map<String, String> originWord = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
                String wordsLowercase = words[i].toLowerCase();
                originWord.put(wordsLowercase, words[i]);
                words[i] = wordsLowercase;
            }
            Arrays.sort(words);
            bw.write(originWord.get(words[0]) + "\n");
        }
        br.close();
        bw.close();
    }
}