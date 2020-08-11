package bj1550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = br.readLine();
        System.out.println(Integer.parseInt(tc, 16));
    }
}
