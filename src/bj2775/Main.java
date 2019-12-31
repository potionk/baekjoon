package bj2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] apartment=new int[14][15];
        for(int i=0; i<14; i++){
            apartment[i][0]=i+1;
        }
        for(int y=1; y<15; y++){
            for(int x=0; x<14; x++){
                int result=0;
                for(int i=0; i<=x; i++){
                    result+=apartment[i][y-1];
                }
                apartment[x][y]=result;
            }
        }
        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(apartment[n-1][k]);
        }
    }
}
