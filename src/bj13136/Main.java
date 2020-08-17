package bj13136;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        System.out.println((long)(Math.ceil(Double.parseDouble(tc[0]) / Double.parseDouble(tc[2])) * Math.ceil(Double.parseDouble(tc[1]) / Double.parseDouble(tc[2]))));
    }
}