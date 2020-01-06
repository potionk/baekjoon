package bj1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num=Integer.parseInt(br.readLine());
        int[][] price=new int[num][3];
        String[] input=br.readLine().split(" ");
        price[0][0]=Integer.parseInt(input[0]);
        price[0][1]=Integer.parseInt(input[1]);
        price[0][2]=Integer.parseInt(input[2]);
        for(int i=1; i<num; i++){
            input=br.readLine().split(" ");
            price[i][0]=Math.min(price[i-1][1], price[i-1][2])+Integer.parseInt(input[0]);
            price[i][1]=Math.min(price[i-1][0], price[i-1][2])+Integer.parseInt(input[1]);
            price[i][2]=Math.min(price[i-1][0], price[i-1][1])+Integer.parseInt(input[2]);
        }
        System.out.println(min(price[num-1][0],price[num-1][1],price[num-1][2]));
    }
    public static int min(int a, int b, int c){
        int[] array={a,b,c};
        Arrays.sort(array);
        return array[0];
    }
}