package bj1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input= Integer.parseInt(br.readLine());
        int[] data=new int[input];
        data[0]=1;
        data[1]=2;
        for(int i=2; i<data.length; i++){
            data[i]=(data[i-1]+data[i-2])%15746;
        }
        System.out.println(data[data.length-1]);
    }
}