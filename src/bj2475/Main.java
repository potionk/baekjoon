package bj2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        int result=0;
        for(int i=0; i<testCase.length; i++){
            int data= Integer.parseInt(testCase[i]);
            result+=data*data;
        }
        System.out.println(result%10);
    }
}