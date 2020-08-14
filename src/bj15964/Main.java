package bj15964;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        System.out.println((long) Math.pow(Double.parseDouble(tc[0]), 2) - (long) Math.pow(Double.parseDouble(tc[1]), 2));
    }
}
