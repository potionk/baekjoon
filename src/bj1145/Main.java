package bj1145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr=br.readLine().split(" ");
        int[] input=new int[inputStr.length];
        long max=1;
        int count=0;
        for(int i=0; i<input.length; i++){
            input[i]= Integer.parseInt(inputStr[i]);
            max*=input[i];
        }
        for(long i=1; i<=max; i++){
            for(int j=0; j<5; j++){
                if(i>=input[j]&&i%input[j]==0)
                    count++;
            }
            if(count>=3){
                System.out.println(i);
                break;
            }
            count=0;
        }
    }
}