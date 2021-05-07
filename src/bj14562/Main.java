package bj14562;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            String[] ST = br.readLine().split(" ");
            int S = Integer.parseInt(ST[0]);
            int T = Integer.parseInt(ST[1]);
            bw.write(bfs(S, T) + "\n");
        }
        br.close();
        bw.close();
    }

    public static int bfs(int S, int T) {
        Queue<ST> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        queue.add(new ST(S, T));
        isVisited.add(S + "," + T);
        int count = 0;
        while (queue.size() != 0) {
            int queueSize = queue.size();
            count++;
            for (int q = 0; q < queueSize; q++) {
                ST p = queue.poll();
                if (!isVisited.contains((p.S + p.S) + "," + (p.T + 3))) {
                    if (p.S * 2 < p.T + 3) {
                        queue.add(new ST(p.S + p.S, p.T + 3));
                        isVisited.add((p.S + p.S) + "," + (p.T + 3));
                    } else if (p.S * 2 == p.T + 3) {
                        return count;
                    }
                }
                if (!isVisited.contains((p.S + 1) + "," + p.T)) {
                    queue.add(new ST(p.S + 1, p.T));
                    isVisited.add((p.S + 1) + "," + p.T);
                    if (p.S + 1 == p.T) {
                        return count;
                    }
                }
            }
        }
        return -1;
    }

    private static class ST {
        int S;
        int T;

        public ST(int s, int t) {
            S = s;
            T = t;
        }
    }
}
