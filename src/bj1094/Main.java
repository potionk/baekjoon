package bj1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase= Integer.toBinaryString(Integer.parseInt(br.readLine()));
        int count=0;
        for(int i=0; i<testCase.length(); i++)
            if(testCase.charAt(i)=='1')
                count++;
        System.out.println(count);
    }
}