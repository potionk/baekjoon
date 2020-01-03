package bj5218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            String[] input=br.readLine().split(" ");
            compareStr(input[0].toCharArray(),input[1].toCharArray());
        }
    }
    public static void compareStr(char[] a, char[] b){
        System.out.print("Distances: ");
        for(int i=0; i<a.length; i++){
            int diff=(int)b[i]-(int)a[i];
            if(diff<0)
                diff+=26;
            System.out.print(diff+" ");
        }
        System.out.println();
    }
}