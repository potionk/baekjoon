package bj1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split("-");
        String[] tcFirst= testCase[0].split("\\+");
        int total=0;
        for(int j=0; j<tcFirst.length; j++){
            total+= Integer.parseInt(tcFirst[j]);
        }
        for(int i=1; i<testCase.length; i++){
            String[] sub=testCase[i].split("\\+");
            for(int j=0; j<sub.length; j++){
                total-= Integer.parseInt(sub[j]);
            }
        }
        System.out.println(total);
    }
}