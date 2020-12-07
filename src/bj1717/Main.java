package bj1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, Integer> parent = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        int n = Integer.parseInt(tc[0]);
        int m = Integer.parseInt(tc[1]);
        makeSet(n);
        for (int i = 0; i < m; i++) {
            String[] readLine = br.readLine().split(" ");
            if (readLine[0].equals("0")) { // union
                union(Integer.parseInt(readLine[1]), Integer.parseInt(readLine[2]));
            } else {
                if (find(Integer.parseInt(readLine[1])) == find(Integer.parseInt(readLine[2]))) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        System.out.println();
    }

    public static void makeSet(int x) {
        for (int i = 0; i <= x; i++) {
            parent.put(i, i);
        }
    }

    public static void union(int x, int y) { // 집합 합치기
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent.put(yRoot, xRoot);
        }
    }

    public static int find(int x) { // x의 루트 반환
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }
}
