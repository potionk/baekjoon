package bj16481;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        double a = 1F / Double.parseDouble(tc[0]);
        double b = 1F / Double.parseDouble(tc[1]);
        double c = 1F / Double.parseDouble(tc[2]);
        System.out.println(1F / (a + b + c));
    }
}
