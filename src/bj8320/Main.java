package bj8320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 1; i <= tc; i++) {
            for (int j = i; i * j <= tc; j++) {
                result++;
            }
        }
        System.out.println(result);
    }
}
