package bj13913;

import java.io.*;
import java.util.LinkedList;

public class Main {
    static boolean[] isVisited;
    static int[] count, beforeIdx;
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] testCase = br.readLine().split(" ");
        int start = Integer.parseInt(testCase[0]);
        int finish = Integer.parseInt(testCase[1]);
        size = Math.max(start, finish);
        isVisited = new boolean[size * 2 + 1];
        count = new int[size * 2 + 1];
        beforeIdx = new int[size * 2 + 1];
        if (start == finish) {
            bw.write(0 + "\n" + start);
        } else {
            bfs(start);
            bw.write(count[finish] + "\n" + findRoute(beforeIdx, start, finish));
        }
        bw.close();
        br.close();
    }

    public static String findRoute(int[] beforeIdx, int start, int finish) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append(finish);
        while (beforeIdx[finish] != start) {
            sb.insert(0, " " + beforeIdx[finish]);
            finish = beforeIdx[finish];
        }
        sb.insert(0, start);
        return sb.toString();
    }

    public static void bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        count[start] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (!(p - 1 < 0) && !isVisited[p - 1]) {
                queue.add(p - 1);
                isVisited[p - 1] = true;
                count[p - 1] = count[p] + 1;
                beforeIdx[p - 1] = p;
            }
            if (!(p + 1 >= size * 2) && !isVisited[p + 1]) {
                queue.add(p + 1);
                isVisited[p + 1] = true;
                count[p + 1] = count[p] + 1;
                beforeIdx[p + 1] = p;
            }
            if (!(p * 2 >= size * 2) && !isVisited[p * 2]) {
                queue.add(p * 2);
                isVisited[p * 2] = true;
                count[p * 2] = count[p] + 1;
                beforeIdx[p * 2] = p;
            }
        }
    }
}