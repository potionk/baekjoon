package bj5543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] burgers=new int[3];
        int[] drinks=new int[2];
        for(int i=0; i<3; i++){
            burgers[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<2; i++){
            drinks[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(burgers);
        Arrays.sort(drinks);
        System.out.println(burgers[0]+drinks[0]-50);
    }
}