package bj9550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            String[] read=br.readLine().split(" ");
            int min=Integer.parseInt(read[1]);
            read=br.readLine().split(" ");
            int[] candies=new int[read.length];
            for(int j=0; j< read.length; j++){
                candies[j]=Integer.parseInt(read[j]);
            }
            int index=0;
            int result=0;
            while(index!=candies.length){
                while(candies[index]>=min){
                    candies[index]-=min;
                    result++;
                }
                index++;
            }
            System.out.println(result);
        }
    }
}