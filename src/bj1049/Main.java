package bj1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tc=br.readLine().split(" ");
        int N= Integer.parseInt(tc[0]);
        int K= Integer.parseInt(tc[1]);
        int[] set=new int[K];
        int[] each=new int[K];
        for(int i=0; i<K; i++){
            String[] input=br.readLine().split(" ");
            set[i]= Integer.parseInt(input[0]);
            each[i]= Integer.parseInt(input[1]);
        }
        Arrays.sort(set);
        Arrays.sort(each);
        int min=Math.min(each[0]*N, N/6*set[0]+(N%6)*each[0]);
        min=Math.min(min, (N/6+1)*set[0]);
        System.out.println(min);
    }
}