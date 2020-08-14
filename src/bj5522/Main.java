package bj5522;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += Integer.parseInt(br.readLine());
        }
        System.out.println(total);
    }
}
