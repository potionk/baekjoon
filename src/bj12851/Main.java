package bj12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static boolean[] isVisited;
    static int size, availCount, finish, minCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        int start = Integer.parseInt(testCase[0]);
        finish = Integer.parseInt(testCase[1]);
        size = Math.max(start, finish);
        isVisited = new boolean[size * 2 + 1];
        availCount = 0;
        if (start == finish) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        bfs(start);
        System.out.println(minCount);
        System.out.println(availCount);
    }

    public static void bfs(int start) {
        LinkedList<QueueData> queue = new LinkedList<>();
        queue.add(new QueueData(start, 0));
        boolean isFind = false;
        isVisited[start] = true;
        minCount = 0;
        while (!queue.isEmpty()) {
            QueueData qd = queue.poll();
            int p = qd.getLoc();
            int c = qd.getCount();
            isVisited[p] = true;
            if (p == finish) {
                if (!isFind) {
                    minCount = c;
                    isFind = true;
                    availCount++;
                } else if (minCount == c) {
                    availCount++;
                }
            }

            if (!(p - 1 < 0) && !isVisited[p - 1]) {
                queue.add(new QueueData(p - 1, c + 1));
            }
            if (!(p + 1 >= size * 2) && !isVisited[p + 1]) {
                queue.add(new QueueData(p + 1, c + 1));
            }
            if (!(p * 2 >= size * 2) && !isVisited[p * 2]) {
                queue.add(new QueueData(p * 2, c + 1));
            }
        }
    }
}

class QueueData {
    private int loc;
    private int count;

    public QueueData(int loc, int count) {
        this.loc = loc;
        this.count = count;
    }

    public int getLoc() {
        return loc;
    }

    public int getCount() {
        return count;
    }
}