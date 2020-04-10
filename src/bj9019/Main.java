package bj9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int finish;
    static char[] bfsClass;
    static boolean[] bfsIsVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        bfsClass = new char[]{'D', 'S', 'L', 'R'};
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            finish = Integer.parseInt(input[1]);
            bfsIsVisited = new boolean[10000];
            bfs(start);
        }
    }

    public static int dslr(char cmd, int arg) {
        switch (cmd) {
            case 'D':
                return (arg * 2) % 10000;
            case 'S':
                if (arg == 0)
                    return 9999;
                else
                    return arg - 1;
            case 'L':
                return (arg*10)%10000+arg/1000;
            case 'R':
                return arg/10+(arg%10)*1000;
        }
        return -1;
    }

    public static void bfs(int start) {
        LinkedList<Data> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int next = dslr(bfsClass[i], start);
            if (!bfsIsVisited[next]) {
                queue.add(new Data(next, bfsClass[i] + ""));
                bfsIsVisited[next] = true;
            }
        }
        while (queue.size() != 0) {
            Data p = queue.poll();
            int cur=p.getCur();
            String route=p.getRoute();
            if (cur == finish) {
                System.out.println(route);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int next = dslr(bfsClass[i], cur);
                if (!bfsIsVisited[next]) {
                    queue.add(new Data(next, route + bfsClass[i]));
                    bfsIsVisited[next] = true;
                }
            }
        }
    }

}

class Data {
    int cur;
    String route;

    public int getCur() {
        return cur;
    }

    public String getRoute() {
        return route;
    }

    public Data(int cur, String route) {
        this.cur = cur;
        this.route = route;
    }
}