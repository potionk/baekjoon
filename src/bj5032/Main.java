package bj5032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase= br.readLine().split(" ");
        int bottle= Integer.parseInt(testCase[0]) + Integer.parseInt(testCase[1]);
        int need = Integer.parseInt(testCase[2]);
        int count=0;
        while(true){
            if(bottle-need>=0){
                count++;
                bottle-=need;
                bottle++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}