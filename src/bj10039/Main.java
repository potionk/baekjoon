package bj10039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total=0;
        int score=0;
        for(int i=0; i<5; i++){
            score=Integer.parseInt(br.readLine());
            if(score<40)
                score=40;
            total+=score;
        }
        System.out.println(total/5);
    }
}