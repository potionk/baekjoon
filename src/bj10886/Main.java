package bj10886;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        int isNotCute=0; // 0
        int isCute=0;    // 1
        for(int i=0; i<testCase; i++){
            if(br.readLine().equals("0"))
                isNotCute++;
            else
                isCute++;
        }
        System.out.println((isCute>isNotCute)?"Junhee is cute!":"Junhee is not cute!");
    }
}