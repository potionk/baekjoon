package bj18352;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmkx = br.readLine().split(" ");
        int n = Integer.parseInt(nmkx[0]);
        int m = Integer.parseInt(nmkx[1]);
        int k = Integer.parseInt(nmkx[2]);
        int x = Integer.parseInt(nmkx[3]);
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph[a - 1].add(b - 1);
        }
        for (int i : bfs(x - 1, n, k, graph)) {
            bw.write(i + "\n");
        }
        br.close();
        bw.close();
    }

    public static List<Integer> bfs(int vertex, int n, int k, List<Integer>[] graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        queue.add(vertex);
        isVisited[vertex] = true;
        int count = 1;
        List<Integer> result = new LinkedList<>();
        while (queue.size() != 0) {
            int queueSize = queue.size();
            for (int q = 0; q < queueSize; q++) {
                int p = queue.poll();
                for (int i : graph[p]) {
                    if (!isVisited[i]) {
                        queue.add(i);
                        isVisited[i] = true;
                        if (count == k) {
                            result.add(i + 1);
                        }
                    }
                }
            }
            count++;
        }
        if (result.size() == 0) {
            result.add(-1);
        } else {
            Collections.sort(result);
        }
        return result;
    }
}