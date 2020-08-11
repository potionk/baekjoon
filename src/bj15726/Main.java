package bj15726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        System.out.println((long) Math.max(Double.parseDouble(tc[0]) * Double.parseDouble(tc[1]) / Double.parseDouble(tc[2]), Double.parseDouble(tc[0]) / Double.parseDouble(tc[1]) * Double.parseDouble(tc[2])));
    }
}
