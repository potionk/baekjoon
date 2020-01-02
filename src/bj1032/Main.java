package bj1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=Integer.parseInt(br.readLine());
        char[] result = br.readLine().toCharArray();
        for(int i=0; i<count-1; i++){
            char[] readline=br.readLine().toCharArray();
            for(int j=0; j<result.length; j++){
                if(readline[j]!=result[j])
                    result[j]='?';
            }
        }
        for (int i=0; i<result.length; i++){
            System.out.print(result[i]);
        }
    }
}