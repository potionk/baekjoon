package bj10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] testCase=new char[5][15];
        int max=-1;
        for(int i=0; i<5; i++){
            testCase[i]=br.readLine().toCharArray();
            max=Math.max(testCase[i].length, max);
        }
        for(int i=0; i<max; i++){
            for(int j=0; j<5; j++){
                if(i<testCase[j].length)
                    System.out.print(testCase[j][i]);
            }
        }
    }
}