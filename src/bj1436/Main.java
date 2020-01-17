package bj1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        int six=666;
        int count=1;
        if(testCase==1){
            System.out.println(six);
            return;
        }
        while(true){
            six++;
            String s2Str=six+"";
            int strLen=s2Str.length();
            for(int i=0; i<strLen-2; i++){
                if(s2Str.charAt(i)=='6'&&s2Str.charAt(i+1)=='6'&&s2Str.charAt(i+2)=='6'){
                    count++;
                    if(count==testCase){
                        System.out.println(six);
                        return;
                    }
                    break;
                }
            }
        }
    }
}