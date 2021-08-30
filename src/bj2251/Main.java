package bj2251;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ABC = br.readLine().split(" ");
        for (int i : bfs(ABC)) {
            bw.write(i + " ");
        }
        br.close();
        bw.close();
    }

    public static List<Integer> bfs(String[] ABC) {
        LinkedList<int[]> queue = new LinkedList<>();
        int[] max = new int[]{Integer.parseInt(ABC[0]), Integer.parseInt(ABC[1]), Integer.parseInt(ABC[2])};
        queue.add(new int[]{0, 0, Integer.parseInt(ABC[2])});
        Set<String> isVisited = new HashSet<>();
        isVisited.add("0-0" + ABC[2]);
        Set<Integer> resultSet = new HashSet<>();
        int[][] nextArrow = {{0, 1}, {0, 2}, {1, 0}, {1, 2}, {2, 0}, {2, 1}};
        while (queue.size() != 0) {
            int[] abc = queue.poll();
            if (abc[0] == 0) {
                resultSet.add(abc[2]);
            }
            for (int i = 0; i < 6; i++) {
                int start = nextArrow[i][0];
                int dest = nextArrow[i][1];
                int[] nextABC = Arrays.copyOf(abc, abc.length);
                nextABC[dest] += nextABC[start];
                nextABC[start] = 0;
                if (nextABC[dest] > max[dest]) {
                    nextABC[start] = nextABC[dest] - max[dest];
                    nextABC[dest] = max[dest];
                }
                String abcStr = nextABC[0] + "-" + nextABC[1] + "-" + nextABC[2];
                if (!isVisited.contains(abcStr)) {
                    isVisited.add(abcStr);
                    queue.add(nextABC);
                }
            }
        }
        List<Integer> result = new ArrayList<>(resultSet.size());
        result.addAll(resultSet);
        Collections.sort(result);
        return result;
    }
}
