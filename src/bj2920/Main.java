package bj2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<input.length; i++){
            sb.append(input[i]);
        }
        if(sb.toString().equals("12345678")){
            System.out.println("ascending");
        }
        else if(sb.toString().equals("87654321")){
            System.out.println("descending");
        }
        else
            System.out.println("mixed");
    }
}