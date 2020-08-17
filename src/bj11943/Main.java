package bj11943;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");
        System.out.println(Math.min(Integer.parseInt(first[0]) + Integer.parseInt(second[1]), Integer.parseInt(first[1]) + Integer.parseInt(second[0])));
    }
}