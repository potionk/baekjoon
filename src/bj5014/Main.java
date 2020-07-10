package bj5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static boolean[] isVisited;
    static int[] count;
    static int F, U, D, G;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        F = Integer.parseInt(testCase[0]);
        int S = Integer.parseInt(testCase[1]);
        G = Integer.parseInt(testCase[2]);
        U = Integer.parseInt(testCase[3]);
        D = Integer.parseInt(testCase[4]);
        isVisited = new boolean[F + 1];
        count = new int[F + 1];
        int result = bfs(S);
        if (result == -1)
            System.out.println("use the stairs");
        else
            System.out.println(result);
    }

    public static int bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        count[start] = 0;
        isVisited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (p == G) {
                return count[p];
            }
            if (!(p + U >= F + 1) && !isVisited[p + U]) {
                queue.add(p + U);
                isVisited[p + U] = true;
                count[p + U] = count[p] + 1;
            }
            if (!(p - D < 1) && !isVisited[p - D]) {
                queue.add(p - D);
                isVisited[p - D] = true;
                count[p - D] = count[p] + 1;
            }
        }
        return -1;
    }
}