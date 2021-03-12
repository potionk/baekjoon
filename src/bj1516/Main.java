package bj1516;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> isDeleted = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        Node[] graph = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new Node();
        }
        for (int i = 1; i <= N; i++) {
            String[] readLine = br.readLine().split(" ");
            int weight = Integer.parseInt(readLine[0]);
            graph[i].setWeight(weight);
            graph[i].setTotalWeight(weight);
            HashSet<Integer> incomingList = graph[i].getIncomingList();
            int idx = 1;
            while (true) {
                int b = Integer.parseInt(readLine[idx++]);
                if (b == -1) {
                    break;
                }
                LinkedList<Integer> list = graph[b].getList();
                list.add(i);
                incomingList.add(b);
            }
        }
        LinkedList<Integer> S = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (graph[i].getIncomingList().size() == 0) {
                S.add(i);
            }
        }
        while (!S.isEmpty()) {
            int n = S.pollFirst();
            if (isDeleted.contains(n)) {
                continue;
            }
            isDeleted.add(n);
            for (int i : graph[n].getList()) {
                graph[i].getIncomingList().remove(n);
            }
            for (int i : graph[n].getList()) {
                graph[i].setTotalWeight(Math.max(graph[i].getTotalWeight(), graph[i].getWeight() + graph[n].getTotalWeight()));
                if (graph[i].getIncomingList().size() == 0) {
                    S.add(i);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            bw.write(graph[i].getTotalWeight() + "\n");
        }
        bw.close();
        br.close();
    }
}

class Node {
    private LinkedList<Integer> list;
    private HashSet<Integer> incomingList;
    private int weight;
    private int totalWeight;

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public LinkedList<Integer> getList() {
        return list;
    }

    public HashSet<Integer> getIncomingList() {
        return incomingList;
    }

    public Node() {
        this.list = new LinkedList<>();
        this.incomingList = new HashSet<>();
        this.totalWeight = 0;
    }
}