package bj1038;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        if (tc < 10) {
            bw.write(tc + "");
        } else {
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                dfs(i, i, list);
            }
            int listSize = list.size();
            if (tc > listSize) {
                bw.write("-1");
            } else {
                Collections.sort(list);
                bw.write(list.get(tc - 1) + "");
            }
        }
        br.close();
        bw.close();
    }

    public static void dfs(int b, long num, ArrayList<Long> list) {
        list.add(num);
        for (int i = b - 1; i >= 0; i--) {
            dfs(i, num * 10 + i, list);
        }
    }
}
