package bj5217;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write("Pairs for " + n + ": ");
            for (int i = 1; i <= n / 2; i++) {
                if (i != (n - i)) {
                    bw.write(i + " " + (n - i));
                    if (i != n / 2 && (i + 1 != n - i - 1)) {
                        bw.write(", ");
                    }
                }
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
