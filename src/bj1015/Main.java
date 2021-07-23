package bj1015;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, PriorityQueue<Integer>> idxMap = new HashMap<>();
        int[] aArr = new int[N];
        int[] aArrOriginal = new int[N];
        String[] readLine = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            aArr[i] = Integer.parseInt(readLine[i]);
            aArrOriginal[i] = aArr[i];
        }
        Arrays.sort(aArr);
        for (int i = 0; i < N; i++) {
            PriorityQueue<Integer> pq = idxMap.getOrDefault(aArr[i], new PriorityQueue<>());
            pq.add(i);
            idxMap.put(aArr[i], pq);
        }
        for (int i = 0; i < N; i++) {
            bw.write(idxMap.get(aArrOriginal[i]).poll() + " ");
        }
        br.close();
        bw.close();
    }
}