package bj14650;

import java.io.*;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = 0;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i < 3; i++) {
            dfs(i, 1, tc);
        }
        bw.write(result + "\n");
        bw.close();
    }

    public static void dfs(int total, int count, int finish) {
        if (count == finish) {
            if (total % 3 == 0) {
                result++;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                dfs(total + i, count + 1, finish);
            }
        }
    }
}