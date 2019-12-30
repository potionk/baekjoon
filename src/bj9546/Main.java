package bj9546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] passengers=new int[31];
        passengers[1]=1;
        for(int i=2; i<passengers.length; i++){
            double result=(passengers[i-1]+0.5)*2;
            passengers[i]= (int) result;
        }
        int count=Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            int input=Integer.parseInt(br.readLine());
            System.out.println(passengers[input]);
        }
    }
}