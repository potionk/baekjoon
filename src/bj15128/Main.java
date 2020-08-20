package bj15128;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        double area = Double.parseDouble(tc[0]) * Double.parseDouble(tc[2]) / Double.parseDouble(tc[1]) / Double.parseDouble(tc[3]) / 2;
        System.out.println(area % 1 == 0 ? 1 : 0);
    }
}
