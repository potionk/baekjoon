package bj3022;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> count = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while (N-- > 0) {
            String name = br.readLine();
            int elseChildCount = 0;
            for (String children : count.keySet()) {
                if (!name.equals(children)) {
                    elseChildCount += count.get(children);
                }
            }
            if (elseChildCount < count.getOrDefault(name, 0)) {
                result++;
            }
            count.merge(name, 1, Integer::sum);
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
