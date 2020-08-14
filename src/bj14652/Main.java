package bj14652;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc=br.readLine().split(" ");
        int M= Integer.parseInt(tc[1]);
        int K= Integer.parseInt(tc[2]);
        System.out.println(K/M+" "+K%M);
    }
}
