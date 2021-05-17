package bj1976;

import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        makeSet(N);
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (readLine[j].equals("1")) {
                    union(i + 1, j + 1);
                }
            }
        }
        String[] travelCourse = br.readLine().split(" ");
        boolean isPossible = true;
        for (int i = 0; i < M - 1; i++) {
            if (find(Integer.parseInt(travelCourse[i])) != find(Integer.parseInt(travelCourse[i + 1]))) {
                isPossible = false;
                bw.write("NO");
                break;
            }
        }
        if (isPossible) {
            bw.write("YES");
        }
        bw.close();
        br.close();
    }

    public static void makeSet(int x) {
        for (int i = 0; i <= x; i++) {
            parent[i] = i;
        }
    }

    public static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
