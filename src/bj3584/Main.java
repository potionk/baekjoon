package bj3584;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            List<Integer>[] tree = new List[N + 1];
            for (int i = 1; i <= N; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int i = 0; i < N - 1; i++) {
                String[] readLine = br.readLine().split(" ");
                int parent = Integer.parseInt(readLine[0]);
                int child = Integer.parseInt(readLine[1]);
                tree[parent].add(child);
            }
            int root = -1;
            Set<Integer> existParent = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                existParent.addAll(tree[i]);
            }
            for (int i = 1; i <= N; i++) {
                if (!existParent.contains(i)) {
                    root = i;
                    break;
                }
            }
            List<Data> route = new ArrayList<>();
            dfs(1, root, new boolean[N + 1], tree, route);
            int start = -1, end = -1;
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            int routeLen = route.size();
            for (int i = 0; i < routeLen; i++) {
                int idx = route.get(i).idx;
                if (idx == a && start == -1) {
                    start = i;
                }
                if (idx == b && end == -1) {
                    end = i;
                }
                if (start != -1 && end != -1) {
                    break;
                }
            }
            if (start > end) {
                start = start ^ end;
                end ^= start;
                start = start ^ end;
            }
            int minDepth = Integer.MAX_VALUE;
            int result = -1;
            for (int i = start; i <= end; i++) {
                if (minDepth > route.get(i).depth) {
                    minDepth = route.get(i).depth;
                    result = route.get(i).idx;
                }
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int depth, int idx, boolean[] visited, List<Integer>[] tree, List<Data> route) {
        route.add(new Data(idx, depth));
        for (int next : tree[idx]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(depth + 1, next, visited, tree, route);
                route.add(new Data(idx, depth));
            }
        }
    }

    private static class Data {
        int idx;
        int depth;

        public Data(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
}
