package bj8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String a="hello";
        System.out.println(a);
        a=a.trim();
        System.out.println(a);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size=br.readLine();
        for(int i=0; i<Integer.parseInt(size); i++){
            String ox=br.readLine();
            int score=0;
            int count=1;
            for(int j=0; j<ox.length(); j++){
                if(ox.charAt(j)=='O'){
                    score+=count;
                    count++;
                }
                else
                    count=1;
            }
            System.out.println(score);
        }
    }
}