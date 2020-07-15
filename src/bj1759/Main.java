package bj1759;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static char[] data;
    static int L, C;
    static boolean[] dfsIsVisited;
    static Map<Integer, Integer> dupCheck;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] size = br.readLine().split(" ");
        L = Integer.parseInt(size[0]);
        C = Integer.parseInt(size[1]);
        data = new char[C];
        dupCheck = new HashMap<>();
        String[] input = br.readLine().split(" ");
        dfsIsVisited = new boolean[C];
        for (int i = 0; i < C; i++) {
            data[i] = input[i].charAt(0);
        }
        Arrays.sort(data);
        dfs(0, 0, 0, 0, 0);
        bw.flush();
    }

    public static void dfs(int index, int curLen, int j, int m, int code) throws IOException {
        if (curLen == L) {
            if (j >= 2 && m >= 1)
                bw.write(code2String(code) + "\n");
            return;
        }
        if (index == C)
            return;
        boolean isVowel = isVowel(data[index]);
        dfs(index + 1, curLen + 1, isVowel ? j : j + 1, isVowel ? m + 1 : m, code + (1 << index));
        dfs(index + 1, curLen, j, m, code);
    }

    //모음인지 확인
    public static boolean isVowel(char input) {
        switch (input) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    // 고유코드를 String으로 변환
    public static String code2String(int code) {
        String bin = Integer.toBinaryString(code);
        char[] toStr = new char[L];
        int len = bin.length();
        for (int i = len - 1, s = 0, dataIndex = 0; i >= 0 && s < L; i--, dataIndex++) {
            if (bin.charAt(i) == '1') {
                toStr[s] = data[dataIndex];
                s++;
            }
        }
        return new String(toStr);
    }
}