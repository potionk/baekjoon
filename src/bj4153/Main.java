package bj4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String input=br.readLine();
            if(input.equals("0 0 0"))
                break;
            String[] side = input.split(" ");
            int[] intSide=new int[side.length];
            for(int i=0; i<side.length; i++){
                intSide[i]=Integer.parseInt(side[i]);
            }
            Arrays.sort(intSide);
            if(intSide[0]*intSide[0]+intSide[1]*intSide[1]==intSide[2]*intSide[2])
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
}