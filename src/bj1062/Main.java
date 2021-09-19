package bj1062;

import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static int[] bitArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        if (k < 5) {
            bw.write("0");
        } else {
            answer = 0;
            bitArr = bitArrInit();
            Set<Character> exceptionTarget = Set.of('a', 'n', 't', 'i', 'c');
            char[] alphabet = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};
            Map<Character, Integer> alphabetIdxMap = new HashMap<>();
            for (int i = 0; i < alphabet.length; i++) {
                alphabetIdxMap.put(alphabet[i], i);
            }
            List<Integer> wordList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                input = input.substring(4, input.length() - 4);
                Set<Character> dupCheck = new HashSet<>();
                int bit = 0;
                int count = 0;
                for (int j = 0; j < input.length(); j++) {
                    char c = input.charAt(j);
                    if (!exceptionTarget.contains(c) && !dupCheck.contains(c)) {
                        bit += bitArr[alphabetIdxMap.get(input.charAt(j))];
                        dupCheck.add(c);
                        count++;
                    }
                }
                if (count <= k - 5) {
                    wordList.add(bit);
                }
            }
            dfs(0, 0, k - 5, 0, new boolean[21], wordList);
            bw.write(answer + "");
        }
        br.close();
        bw.close();
    }

    private static int[] bitArrInit() {
        int[] arr = new int[21];
        for (int i = 1, idx = 20; idx >= 0; i *= 2, idx--) {
            arr[idx] = i;
        }
        return arr;
    }

    public static void dfs(int idx, int num, int max, int visitedBit, boolean[] isVisited, List<Integer> wordList) {
        if (num == max) {
            int count = 0;
            for (int i : wordList) {
                if ((i & visitedBit) == i) {
                    count++;
                }
            }
            answer = Math.max(count, answer);
        } else {
            for (int i = idx; i < 21; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    visitedBit += bitArr[i];
                    dfs(i + 1, num + 1, max, visitedBit, isVisited, wordList);
                    visitedBit -= bitArr[i];
                    isVisited[i] = false;
                }
            }
        }
    }
}