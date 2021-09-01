package bj13015;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            bw.write(getXLine(i, N));
        }
        for (int i = N - 2; i >= 0; i--) {
            bw.write(getXLine(i, N));
        }
        br.close();
        bw.close();
    }

    public static String getXLine(int i, int N) {
        String middle;
        if (i == 0) {
            middle = repeatChar('*', N);
            middle = middle + repeatChar(' ', (N - i) * 2 - 3) + middle;
        } else if (i == N - 1) {
            middle = "*" + repeatChar(' ', N - 2) + "*" + repeatChar(' ', N - 2) + "*";
        } else {
            middle = "*" + repeatChar(' ', N - 2) + "*";
            middle = middle + repeatChar(' ', (N - i) * 2 - 3) + middle;
        }
        return repeatChar(' ', i) + middle + "\n";
    }

    public static String repeatChar(char c, int num) {
        StringBuilder sb = new StringBuilder();
        while (num-- > 0) {
            sb.append(c);
        }
        return sb.toString();
    }
}