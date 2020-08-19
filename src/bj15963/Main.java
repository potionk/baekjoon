package bj15963;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        if (tc[0].equals(tc[1])) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
