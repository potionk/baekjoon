package bj2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        int array[]=new int[size];
        for(int i=0; i<size; i++){
            array[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        for(int i=0; i<size; i++){
            System.out.println(array[i]);
        }
    }
}
