package bj5565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total=Integer.parseInt(br.readLine());
        int readable=0;
        for(int i=0; i<9; i++){
            readable += Integer.parseInt(br.readLine());
        }
        System.out.println(total-readable);
    }
}