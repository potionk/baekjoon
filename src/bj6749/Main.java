package bj6749;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int youngest = Integer.parseInt(br.readLine());
        int middle = Integer.parseInt(br.readLine());
        System.out.println(2 * middle - youngest);
    }
}