package bj1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag=false;
        int count=0;
        for(int i=0; i<8; i++){
            String readline=br.readLine();
            int startIndex=0;
            if(flag)
                startIndex=1;
            for(int j=startIndex; j<8; j+=2){
                if(readline.charAt(j)=='F')
                    count++;
            }
            flag=!flag;
        }
        System.out.println(count);
    }
}