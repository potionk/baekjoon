package bj16017;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tel = new int[4];
        for (int i = 0; i < 4; i++) {
            tel[i] = Integer.parseInt(br.readLine());
        }
        if ((tel[0] == 8 || tel[0] == 9) && (tel[3] == 8 || tel[3] == 9) && (tel[1] == tel[2])) {
            System.out.println("ignore");
        } else {
            System.out.println("answer");
        }
    }
}