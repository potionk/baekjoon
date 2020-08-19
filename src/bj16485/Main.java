package bj16485;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        double c = Double.parseDouble(tc[0]);
        double b = Double.parseDouble(tc[1]);
        System.out.println(c / b);
    }
}
