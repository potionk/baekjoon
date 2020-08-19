package bj16484;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        double d = Double.parseDouble(tc[0]);
        double n = Double.parseDouble(tc[1]);
        System.out.println(d / 2 - n);
    }
}
