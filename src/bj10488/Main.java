package bj10488;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data=new int[44];
        Map<Integer, Integer> eureka=new HashMap<>();
        for(int i=1; i<data.length+1; i++){
            data[i-1]=i*(i+1)/2;
        }
        for(int i=0; i<data.length-2; i++){
            for(int j=i; j<data.length-1; j++){
                for(int k=j; k<data.length; k++){
                    eureka.put(data[i]+data[j]+data[k],1);
                }
            }
        }
        int testCase= Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int input= Integer.parseInt(br.readLine());
            if(eureka.get(input)==null)
                System.out.println(0);
            else
                System.out.println(1);
        }
    }
}