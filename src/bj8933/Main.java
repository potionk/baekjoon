package bj8933;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] info = br.readLine().split(" ");
            int k = Integer.parseInt(info[0]);
            Map<Long, Integer> countMCS = new HashMap<>();
            int[] count = new int[4];
            char[] W = info[1].toCharArray();
            int len = W.length;
            for (int i = 0; i < k; i++) {
                switch (W[i]) {
                    case 'A' -> count[0]++;
                    case 'G' -> count[1]++;
                    case 'T' -> count[2]++;
                    case 'C' -> count[3]++;
                }
            }
            Long code = getMSCCode(count);
            countMCS.put(code, 1);
            int result = 1;
            for (int i = 1; i < len - k + 1; i++) {
                switch (W[i - 1]) {
                    case 'A' -> count[0]--;
                    case 'G' -> count[1]--;
                    case 'T' -> count[2]--;
                    case 'C' -> count[3]--;
                }
                switch (W[i + k - 1]) {
                    case 'A' -> count[0]++;
                    case 'G' -> count[1]++;
                    case 'T' -> count[2]++;
                    case 'C' -> count[3]++;
                }
                code = getMSCCode(count);
                countMCS.merge(code, 1, Integer::sum);
            }
            for (int c : countMCS.values()) {
                result = Math.max(c, result);
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    public static long getMSCCode(int[] count) {
        return (long) count[0] * 601 * 601 * 601 + (long) count[1] * 601 * 601 + count[2] * 601L + count[3];
    }
}
