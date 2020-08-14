package bj10998;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        System.out.println(Integer.parseInt(testCase[0])*Integer.parseInt(testCase[1]));
    }
}
