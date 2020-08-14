package bj14918;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        System.out.println(Integer.parseInt(tc[0]) + Integer.parseInt(tc[1]));
    }
}
