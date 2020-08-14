package bj15727;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int total = tc / 5;
        if (tc % 5 > 0) {
            System.out.println(total + 1);
        } else {
            System.out.println(total);
        }
    }
}
