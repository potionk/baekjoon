package bj2845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] LP = br.readLine().split(" ");
        int people = Integer.parseInt(LP[0]) * Integer.parseInt(LP[1]);
        String[] tc = br.readLine().split(" ");
        for (String s : tc) {
            System.out.print(Integer.parseInt(s) - people + " ");
        }
    }
}
