package bj2010;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcNum = Integer.parseInt(br.readLine());
        int total = 1;
        for (int i = 0; i < tcNum; i++) {
            total--;
            total += Integer.parseInt(br.readLine());
        }
        System.out.println(total);
    }
}
