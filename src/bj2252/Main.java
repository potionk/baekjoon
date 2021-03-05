package bj2252;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        Set<Integer> isDeleted = new HashSet<>();
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        Node[] graph = new Node[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new Node();
        }
        for (int i = 0; i < M; i++) {
            String[] readLine = br.readLine().split(" ");
            int a = Integer.parseInt(readLine[0]) - 1;
            int b = Integer.parseInt(readLine[1]) - 1;
            LinkedList<Integer> list = graph[a].getList();
            list.add(b);
            HashSet<Integer> incomingList = graph[b].getIncomingList();
            incomingList.add(a);
        }
        LinkedList<Integer> S = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (graph[i].getIncomingList().size() == 0) {
                S.add(i);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        while (!S.isEmpty()) {
            int n = S.pollFirst();
            if (isDeleted.contains(n)) {
                continue;
            }
            isDeleted.add(n);
            queue.add(n);
            for (int i : graph[n].getList()) {
                graph[i].getIncomingList().remove(n);
            }
            for (int i : graph[n].getList()) {
                if (graph[i].getIncomingList().size() == 0) {
                    S.add(i);
                }
            }
        }
        for (int s : queue) {
            bw.write((s + 1) + " ");
        }
        bw.close();
        br.close();
    }
}

class Node {
    LinkedList<Integer> list;
    HashSet<Integer> incomingList;

    public LinkedList<Integer> getList() {
        return list;
    }

    public HashSet<Integer> getIncomingList() {
        return incomingList;
    }

    public Node() {
        this.list = new LinkedList<>();
        this.incomingList = new HashSet<>();
    }
}

