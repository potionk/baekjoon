package bj16928;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        Map<Integer, Integer> portal = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            String[] portalInfo = br.readLine().split(" ");
            portal.put(Integer.parseInt(portalInfo[0]), Integer.parseInt(portalInfo[1]));
        }
        bw.write(bfs(portal) + "");
        br.close();
        bw.close();
    }

    public static int bfs(Map<Integer, Integer> portal) {
        LinkedList<Data> queue = new LinkedList<>();
        queue.add(new Data(1, 0));
        boolean[] isVisited = new boolean[106];
        while (queue.size() != 0) {
            Data current = queue.poll();
            int curIdx = current.idx;
            int curCount = current.count;
            if (curIdx == 100) {
                return curCount;
            }
            for (int i = 1; i <= 6; i++) {
                int next = curIdx + i;
                if (!isVisited[next]) {
                    if (portal.containsKey(next)) {
                        queue.add(new Data(portal.get(next), curCount + 1));
                        isVisited[portal.get(next)] = true;
                    } else {
                        queue.add(new Data(next, curCount + 1));
                        isVisited[next] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static class Data {
        int idx;
        int count;

        public Data(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }
}
