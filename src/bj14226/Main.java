package bj14226;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int S = Integer.parseInt(br.readLine());
        bw.write(bfs(S, new boolean[S + 1]) + "");
        br.close();
        bw.close();
    }

    public static int bfs(int target, boolean[] numIsVisited) {
        LinkedList<Data> queue = new LinkedList<>();
        queue.add(new Data(1, 0, 0));
        numIsVisited[0] = true;
        numIsVisited[1] = true;
        int count = -1;
        HashSet<String> dupCheck = new HashSet<>();
        dupCheck.add("1,0");
        while (queue.size() != 0) {
            int queueSize = queue.size();
            count++;
            for (int q = 0; q < queueSize; q++) {
                Data data = queue.poll();
                int num = data.num;
                int clipboard = data.clipboard;
                int time = data.time;
                if (num == target) {
                    return count;
                }
                for (int i = 0; i < 3; i++) {
                    int newNum = 0, newClipboard = 0;
                    switch (i) {
                        case 0 -> {
                            newNum = num;
                            newClipboard = num;
                        }
                        case 1 -> {
                            if (clipboard == 0) {
                                continue;
                            }
                            newNum = num + clipboard;
                            newClipboard = clipboard;
                        }
                        case 2 -> {
                            newNum = num - 1;
                            newClipboard = clipboard;
                        }
                    }
                    if (!dupCheck.contains(newNum + "," + newClipboard) && newNum > 0) {
                        queue.add(new Data(newNum, newClipboard, time + 1));
                        dupCheck.add(newNum + "," + newClipboard);
                    }
                }
            }
        }
        return -1;
    }

    private static class Data {
        int num;
        int clipboard;
        int time;

        public Data(int num, int clipboard, int time) {
            this.num = num;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
