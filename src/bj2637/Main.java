package bj2637;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> isDeleted = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Node[] graph = new Node[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new Node();
        }
        for (int i = 0; i < M; i++) {
            String[] readLine = br.readLine().split(" ");
            int a = Integer.parseInt(readLine[0]) - 1;
            int b = Integer.parseInt(readLine[1]) - 1;
            int requirement = Integer.parseInt(readLine[2]);
            graph[a].getList().add(new Data(b, requirement));
            graph[b].getIncomingList().add(a);
        }
        int[] result = new int[N];
        result[N - 1] = 1;
        Queue<Integer> S = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (graph[i].getIncomingList().size() == 0) {
                S.add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        while (!S.isEmpty()) {
            int n = S.poll();
            if (!isDeleted.contains(n)) {
                isDeleted.add(n);
                queue.add(n);
                for (Data i : graph[n].getList()) {
                    graph[i.component].getIncomingList().remove(n);
                    result[i.component] += result[n] * i.requirement;
                }
                if (!graph[n].getList().isEmpty()) {
                    result[n] = 0;
                }
                for (Data i : graph[n].getList()) {
                    if (graph[i.component].getIncomingList().size() == 0) {
                        S.add(i.component);
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (result[i] != 0) {
                bw.write((i + 1) + " " + result[i] + "\n");
            }
        }
        bw.close();
        br.close();
    }
}

class Node {
    LinkedList<Data> list;
    HashSet<Integer> incomingList;

    public LinkedList<Data> getList() {
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

class Data {
    int component;
    int requirement;

    public Data(int component, int requirement) {
        this.component = component;
        this.requirement = requirement;
    }
}