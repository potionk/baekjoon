package bj2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        boolean[][] field=new boolean[100][100];
        for(int i=0; i<testCase; i++){
            String[] read=br.readLine().split(" ");
            int x= Integer.parseInt(read[0]);
            int y= Integer.parseInt(read[1]);
            for(int j=y; j<y+10; j++){
                for(int k=x; k<x+10; k++){
                    field[j][k]=true;
                }
            }
        }
        int count=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(field[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }
}