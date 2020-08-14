package bj11382;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc=br.readLine().split(" ");
        System.out.println(Long.parseLong(tc[0])+Long.parseLong(tc[1])+Long.parseLong(tc[2]));
    }
}
