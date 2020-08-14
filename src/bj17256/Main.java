package bj17256;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        String[] c = br.readLine().split(" ");
        System.out.println((Integer.parseInt(c[0]) - Integer.parseInt(a[2])) + " " + (Integer.parseInt(c[1]) / Integer.parseInt(a[1])) + " " + (Integer.parseInt(c[2]) - Integer.parseInt(a[0])));
    }
}