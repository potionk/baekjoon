package bj2446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=testCase*2-1, blank=0; i>0; i-=2, blank++){
            System.out.print(makeBlank(blank));
            System.out.println(makeStar(i));
        }
        for(int i=3, blank=testCase-2; i<testCase*2; i+=2, blank--){
            System.out.print(makeBlank(blank));
            System.out.println(makeStar(i));
        }
    }

    public static String makeStar(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    public static String makeBlank(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}