package bj5596;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mgScore=br.readLine().split(" ");
        int mgTotal=0;
        String[] msScore=br.readLine().split(" ");
        int msTotal=0;
        for(int i=0; i<msScore.length; i++){
            mgTotal+=Integer.parseInt(mgScore[i]);
            msTotal+=Integer.parseInt(msScore[i]);
        }
        System.out.println(mgTotal>=msTotal?mgTotal:msTotal);
    }
}