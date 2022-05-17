package bj5568;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String[] cards;
    static int totalNum;
    static int selectNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        totalNum = Integer.parseInt(br.readLine());
        cards = new String[totalNum];
        selectNum = Integer.parseInt(br.readLine());
        Set<String> dupCheckSet = new HashSet<>();
        for (int i = 0; i < totalNum; i++) {
            cards[i] = br.readLine();
        }
        dfs(new boolean[totalNum], 0, dupCheckSet, "");
        bw.write(dupCheckSet.size() + "");
        br.close();
        bw.close();
    }

    public static void dfs(boolean[] visited, int count, Set<String> dupCheck, String s) {
        if (count < selectNum) {
            for (int i = 0; i < totalNum; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(visited, count + 1, dupCheck, s + cards[i]);
                    visited[i] = false;
                }
            }
        } else {
            dupCheck.add(s);
        }
    }
}
