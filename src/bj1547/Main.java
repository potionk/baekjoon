package bj1547;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        boolean[] position = new boolean[3];
        position[0] = true;
        for (int i = 0; i < m; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]) - 1;
            int y = Integer.parseInt(xy[1]) - 1;
            boolean temp = position[x];
            position[x] = position[y];
            position[y] = temp;
        }
        for (int i = 0; i < 3; i++) {
            if (position[i]) {
                bw.write((i + 1) + "");
                break;
            }
        }
        br.close();
        bw.close();
    }
}
