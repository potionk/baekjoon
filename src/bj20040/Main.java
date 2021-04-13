package bj20040;

import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int n = Integer.parseInt(tc[0]);
        int m = Integer.parseInt(tc[1]);
        parent = new int[n];
        makeSet(n);
        boolean isCycle = false;
        int count = 0;
        for (int i = 0; i < m; i++) {
            count++;
            String[] readLine = br.readLine().split(" ");
            int a = Integer.parseInt(readLine[0]);
            int b = Integer.parseInt(readLine[1]);
            if (find(a) == find(b)) {
                bw.write(count + "");
                isCycle = true;
                break;
            } else {
                union(a, b);
            }
        }
        if (!isCycle) {
            bw.write("0");
        }
        bw.close();
        br.close();
    }

    public static void makeSet(int x) {
        for (int i = 0; i < x; i++) {
            parent[i] = i;
        }
    }

    public static void union(int x, int y) { // 집합 합치기
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }

    public static int find(int x) { // x의 루트 반환
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}