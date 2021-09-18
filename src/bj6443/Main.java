package bj6443;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] word = br.readLine().toCharArray();
            Arrays.sort(word);
            dfs("", word, 0, word.length, new boolean[word.length], new HashSet<>());
        }
        br.close();
        bw.close();
    }

    public static void dfs(String s, char[] word, int curLen, int len, boolean[] isVisited, Set<String> dupCheck) throws IOException {
        if (dupCheck.contains(s)) {
            return;
        }
        dupCheck.add(s);
        if (curLen == len) {
            bw.write(s + "\n");
        } else {
            for (int i = 0; i < len; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(s + word[i], word, curLen + 1, len, isVisited, dupCheck);
                    isVisited[i] = false;
                }
            }
        }
    }
}