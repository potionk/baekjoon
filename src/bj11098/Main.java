package bj11098;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int p = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            String name = "";
            while (p-- > 0) {
                String[] info = br.readLine().split(" ");
                int price = Integer.parseInt(info[0]);
                if (price > max) {
                    name = info[1];
                    max = price;
                }
            }
            bw.write(name + "\n");
        }
        br.close();
        bw.close();
    }
}
