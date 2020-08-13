package bj16480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc = br.readLine().split(" ");
        System.out.println(Long.parseLong(tc[0]) * (Long.parseLong(tc[0]) - 2 * Long.parseLong(tc[1])));
    }
}
