package bj1568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int birds=Integer.parseInt(br.readLine());
        int sec=0;
        int count=1;
        while(birds>0){
            if(birds>=count)
                birds-=count++;
            else{
                count=1;
                birds-=count++;
            }
            sec++;
        }
        System.out.println(sec);
    }
}