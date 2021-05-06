package bj1253;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> Ai = new HashSet<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        String[] AStr = br.readLine().split(" ");
        int[] A = new int[N];
        int idx = 0;
        for (String s : AStr) {
            int i = Integer.parseInt(s);
            Ai.add(i);
            A[idx++] = i;
            countMap.merge(i, 1, Integer::sum);
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (Ai.contains(A[i] - A[j])) {
                    if (A[i] - A[j] == A[j] && countMap.get(A[j]) < 2) {
                        continue;
                    } else if (A[i] - A[j] == A[i] && countMap.get(A[i]) < 2) {
                        continue;
                    } else if (A[i] == A[j] && A[i] == 0 && countMap.get(A[j]) <= 2) {
                        continue;
                    }
                    result++;
                    break;
                }
            }
        }
        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
