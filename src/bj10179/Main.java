package bj10179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            double tc = Double.parseDouble(br.readLine());
            System.out.println("$" + String.format("%.2f", tc * 0.8));
        }
    }
}
