package bj17496;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        int num = Integer.parseInt(tc[0]) / Integer.parseInt(tc[1]);
        if (Integer.parseInt(tc[0]) % Integer.parseInt(tc[1]) == 0) {
            num--;
        }
        System.out.println(num * Integer.parseInt(tc[2]) * Integer.parseInt(tc[3]));
    }
}