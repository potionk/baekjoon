package bj9466;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        while (tcNum-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] studentsInfo = new int[n];
            int[] count = new int[n];
            int[] start = new int[n];
            String[] studentsInfoStr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                studentsInfo[i] = Integer.parseInt(studentsInfoStr[i]) - 1;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (count[i] == 0) {
                    result += dfs(i, studentsInfo, count, start, i, 1);
                }
            }
            bw.write(n - result + "\n");
        }
        br.close();
        bw.close();
    }

    public static int dfs(int idx, int[] studentInfo, int[] count, int[] start, int startIdx, int depth) {
        start[idx] = startIdx;
        count[idx] = depth;
        int nextIdx = studentInfo[idx];
        if (count[nextIdx] != 0) {
            if (startIdx == start[nextIdx]) {
                return depth - count[nextIdx] + 1;
            }
        } else {
            return dfs(nextIdx, studentInfo, count, start, startIdx, depth + 1);
        }
        return 0;
    }
}
