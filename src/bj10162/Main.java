package bj10162;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        if (tc % 10 != 0) {
            System.out.println(-1);
            return;
        }
        System.out.print(tc / 300 + " ");
        tc -= tc / 300 * 300;
        System.out.print(tc / 60 + " ");
        tc -= tc / 60 * 60;
        System.out.println(tc / 10);
    }
}