package bj1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size=Integer.parseInt(br.readLine());
        int[] arrayA=new int[size];
        int[] arrayB=new int[size];
        int total=0;
        String input[] = br.readLine().split(" ");
        for(int i=0; i<size; i++){
            arrayA[i]=Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i=0; i<size; i++){
            arrayB[i]=Integer.parseInt(input[i]);
        }
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        for(int i=0; i<size; i++){
            total+=arrayA[i]*arrayB[size-1-i];
        }
        System.out.println(total);
    }
}
