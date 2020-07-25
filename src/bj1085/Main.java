package bj1085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int[] result=new int[4];
        result[0]=Integer.parseInt(input[0]);
        result[1]=Integer.parseInt(input[1]);
        result[2]=Integer.parseInt(input[2])-result[0];
        result[3]=Integer.parseInt(input[3])-result[1];
        System.out.println(findMin(result));
    }
    public static int findMin(int[] arr){
        int min= Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            min=Math.min(min, arr[i]);
        }
        return min;
    }
}