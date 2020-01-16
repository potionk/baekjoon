package bj2847;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        int[] data=new int[testCase];
        int count=0;
        for(int i=0; i< data.length; i++){
            data[i]= Integer.parseInt(br.readLine());
        }
        for(int i=data.length-2; i>=0; i--){
            if(data[i]>=data[i+1]) {
                count += data[i] - data[i + 1] + 1;
                data[i] = data[i + 1] - 1;
            }
        }
        System.out.println(count);
    }
}