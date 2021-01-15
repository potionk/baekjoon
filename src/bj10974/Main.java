package bj10974;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<String> permutationList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        permutationList = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        char[] word = new char[n];
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            word[i] = (char) ((i + 1) + '0');
        }
        for (int i = 0; i < n; i++) {
            isVisited[i] = true;
            dfs(word, 1, word[i] + " ", isVisited, n);
            isVisited[i] = false;
        }
        Collections.sort(permutationList);
        for (String s : permutationList) {
            bw.write(s + "\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(char[] word, int count, String result, boolean[] isVisited, int size) {
        if (count == size) {
            permutationList.add(result);
        }
        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(word, count + 1, result + word[i] + " ", isVisited, size);
                isVisited[i] = false;
            }
        }
    }
}
