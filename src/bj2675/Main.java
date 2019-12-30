package bj2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<size; i++){
            String input[] = br.readLine().split(" ");
            for(int j=0; j<input[1].length(); j++){
                for(int k=0; k<Integer.parseInt(input[0]); k++){
                    sb.append(input[1].charAt(j));
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}