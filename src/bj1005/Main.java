package bj1005;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        while (tcNum-- > 0) {
            Set<Integer> isDeleted = new HashSet<>();
            String[] NK = br.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);
            Node[] graph = new Node[N + 1];
            String[] costStr = br.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                graph[i] = new Node(Integer.parseInt(costStr[i - 1]));
            }
            for (int i = 0; i < K; i++) {
                String[] readLine = br.readLine().split(" ");
                int a = Integer.parseInt(readLine[1]);
                int b = Integer.parseInt(readLine[0]);
                HashSet<Integer> incomingList = graph[a].getIncomingList();
                LinkedList<Integer> list = graph[b].getList();
                list.add(a);
                incomingList.add(b);
            }
            int W = Integer.parseInt(br.readLine());
            LinkedList<Integer> S = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
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
                    graph[i].setTotalWeight(Math.max(graph[i].getTotalWeight(), graph[i].getWeight() + graph[n].getTotalWeight()));
                    if (graph[i].getIncomingList().size() == 0) {
                        S.add(i);
                    }
                }
            }
            bw.write(graph[W].getTotalWeight() + "\n");
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

    public Node(int weight) {
        this.list = new LinkedList<>();
        this.incomingList = new HashSet<>();
        this.totalWeight = weight;
        this.weight = weight;
    }
}