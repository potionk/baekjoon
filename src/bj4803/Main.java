package bj4803;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nm;
        int caseIdx = 1;
        while (!(nm = br.readLine()).equals("0 0")) {
            String[] nmSplit = nm.split(" ");
            int n = Integer.parseInt(nmSplit[0]);
            int m = Integer.parseInt(nmSplit[1]);
            List<Integer>[] tree = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = new LinkedList<>();
            }
            for (int i = 0; i < m; i++) {
                String[] edges = br.readLine().split(" ");
                int a = Integer.parseInt(edges[0]);
                int b = Integer.parseInt(edges[1]);
                tree[a].add(b);
                tree[b].add(a);
            }
            boolean[] visited = new boolean[n + 1];
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    NumberOfNodeAndEdge number = dfs(i, tree, visited);
                    if (number.nodeNum - 1 == number.edgeNum / 2) {
                        count++;
                    }
                }
            }
            bw.write("Case " + caseIdx + ": ");
            if (count == 0) {
                bw.write("No trees.\n");
            } else if (count == 1) {
                bw.write("There is one tree.\n");
            } else {
                bw.write("A forest of " + count + " trees.\n");
            }
            caseIdx++;
        }
        br.close();
        bw.close();
    }

    public static NumberOfNodeAndEdge dfs(int node, List<Integer>[] tree, boolean[] visited) {
        NumberOfNodeAndEdge number = new NumberOfNodeAndEdge(1, tree[node].size());
        for (int next : tree[node]) {
            if (!visited[next]) {
                visited[next] = true;
                NumberOfNodeAndEdge result = dfs(next, tree, visited);
                number.nodeNum += result.nodeNum;
                number.edgeNum += result.edgeNum;
            }
        }
        return number;
    }

    private static class NumberOfNodeAndEdge {
        int nodeNum;
        int edgeNum;

        public NumberOfNodeAndEdge(int nodeNum, int edgeNum) {
            this.nodeNum = nodeNum;
            this.edgeNum = edgeNum;
        }
    }
}