package bj18330;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int max = k + 60;
        if (n <= max) {
            bw.write(n * 1500 + "");
        } else {
            int cost = max * 1500;
            n -= max;
            cost += n * 3000;
            bw.write(cost + "");
        }
        br.close();
        bw.close();
    }
}
